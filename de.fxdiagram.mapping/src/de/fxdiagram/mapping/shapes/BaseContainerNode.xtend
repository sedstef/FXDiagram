package de.fxdiagram.mapping.shapes

import de.fxdiagram.annotations.properties.FxProperty
import de.fxdiagram.annotations.properties.ModelNode
import de.fxdiagram.core.XDiagram
import de.fxdiagram.core.XDiagramContainer
import de.fxdiagram.core.XNode
import de.fxdiagram.lib.anchors.RoundedRectangleAnchors
import de.fxdiagram.lib.nodes.RectangleBorderPane
import de.fxdiagram.mapping.ConnectionMapping
import de.fxdiagram.mapping.IMappedElementDescriptor
import de.fxdiagram.mapping.reconcile.NodeReconcileBehavior
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Group
import javafx.scene.layout.VBox

import static de.fxdiagram.mapping.reconcile.MappingLabelListener.*
import static javafx.geometry.Side.*

import static extension de.fxdiagram.core.extensions.CoreExtensions.*
import static extension de.fxdiagram.mapping.behavior.LazyConnectionMappingBehavior.*
import static extension de.fxdiagram.mapping.shapes.BaseShapeInitializer.*

/**
 * Base implementation for an {@link XNode} that contains other nodes and belongs to an {@link IMappedElementDescriptor}.
 * 
 * If the descriptor is an {@link AbstractXtextDescriptor}, members are automatically injected using
 * the Xtext language's injector. 
 */
@ModelNode
class BaseContainerNode<T> extends XNode implements INodeWithLazyMappings, XDiagramContainer {
	
	public static val NODE_HEADING = 'containerNodeHeading'
	
	@FxProperty XDiagram innerDiagram = new XDiagram
	
	Group diagramGroup
	
	new() {
		initializeLazily
	}

	new(IMappedElementDescriptor<T> descriptor) {
		super(descriptor)
	}
	
	override IMappedElementDescriptor<T> getDomainObjectDescriptor() {
		super.domainObjectDescriptor as IMappedElementDescriptor<T>
	}
	
	override protected createNode() {
		val titleArea = new VBox
		val pane = new RectangleBorderPane => [
			padding = this.insets
			children += new VBox => [
				alignment = Pos.CENTER
				spacing = 10
				children += titleArea
				children += diagramGroup = new Group
			]
		]
		addMappingLabelListener(labels, NODE_HEADING -> titleArea)
		pane	
	}
	
	override doActivate() {
		diagramGroup.children += innerDiagram => [
			isRootDiagram = false
			parentDiagram = this.diagram 			
		]
		innerDiagram.activate
		super.doActivate
		addLazyBehavior(domainObjectDescriptor)
		addBehavior(new NodeReconcileBehavior(this))
		// move container node when the inner diagram grows to the upper/left
		innerDiagram.boundsInLocalProperty.addListener [ p, o, n |
			layoutX = layoutX  + (n.minX - o.minX)  
			layoutY = layoutY +  (n.minY - o.minY)
		]	
	}
	
	override getButtonSides(ConnectionMapping<?> mapping) {
		#[ TOP, BOTTOM, LEFT, RIGHT ]
	}

	override protected createAnchors() {
		new RoundedRectangleAnchors(this, 12, 12)
	}

	override getInsets() {
		new Insets(10,20,20,20)
	}
	
	override toFront() {
		super.toFront()
		(innerDiagram.nodes + innerDiagram.connections).forEach[toFront]
	}
	
	override isInnerDiagramActive() {
		isActive
	}
}