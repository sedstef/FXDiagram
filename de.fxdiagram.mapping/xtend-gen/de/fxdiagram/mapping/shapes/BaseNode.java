package de.fxdiagram.mapping.shapes;

import de.fxdiagram.annotations.properties.ModelNode;
import de.fxdiagram.core.XNode;
import de.fxdiagram.core.anchors.Anchors;
import de.fxdiagram.core.model.DomainObjectDescriptor;
import de.fxdiagram.core.model.ModelElementImpl;
import de.fxdiagram.lib.anchors.RoundedRectangleAnchors;
import de.fxdiagram.lib.nodes.RectangleBorderPane;
import de.fxdiagram.mapping.ConnectionMapping;
import de.fxdiagram.mapping.IMappedElementDescriptor;
import de.fxdiagram.mapping.behavior.LazyConnectionMappingBehavior;
import de.fxdiagram.mapping.behavior.NodeReconcileBehavior;
import de.fxdiagram.mapping.shapes.BaseShapeInitializer;
import de.fxdiagram.mapping.shapes.INodeWithLazyMappings;
import java.util.Collections;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * Base implementation for an {@link XNode} that belongs to an {@link IMappedElementDescriptor}.
 * 
 * If the descriptor is an {@link AbstractXtextDescriptor}, members are automatically injected using
 * the Xtext language's injector.
 */
@ModelNode
@SuppressWarnings("all")
public class BaseNode<T extends Object> extends XNode implements INodeWithLazyMappings {
  public BaseNode() {
    BaseShapeInitializer.initializeLazily(this);
  }
  
  public BaseNode(final IMappedElementDescriptor<T> descriptor) {
    super(descriptor);
  }
  
  @Override
  public IMappedElementDescriptor<T> getDomainObjectDescriptor() {
    DomainObjectDescriptor _domainObjectDescriptor = super.getDomainObjectDescriptor();
    return ((IMappedElementDescriptor<T>) _domainObjectDescriptor);
  }
  
  @Override
  protected Node createNode() {
    RectangleBorderPane _rectangleBorderPane = new RectangleBorderPane();
    final Procedure1<RectangleBorderPane> _function = (RectangleBorderPane it) -> {
      ObservableList<Node> _children = it.getChildren();
      Text _text = new Text();
      final Procedure1<Text> _function_1 = (Text it_1) -> {
        it_1.setTextOrigin(VPos.TOP);
        String _name = this.getName();
        it_1.setText(_name);
        Insets _insets = new Insets(10, 20, 10, 20);
        StackPane.setMargin(it_1, _insets);
        Font _font = it_1.getFont();
        String _family = _font.getFamily();
        Font _font_1 = it_1.getFont();
        double _size = _font_1.getSize();
        double _multiply = (_size * 1.1);
        Font _font_2 = Font.font(_family, FontWeight.BOLD, _multiply);
        it_1.setFont(_font_2);
      };
      Text _doubleArrow = ObjectExtensions.<Text>operator_doubleArrow(_text, _function_1);
      _children.add(_doubleArrow);
      Color _rgb = Color.rgb(158, 188, 227);
      Stop _stop = new Stop(0, _rgb);
      Color _rgb_1 = Color.rgb(220, 230, 255);
      Stop _stop_1 = new Stop(1, _rgb_1);
      LinearGradient _linearGradient = new LinearGradient(
        0, 0, 1, 1, 
        true, CycleMethod.NO_CYCLE, 
        Collections.<Stop>unmodifiableList(CollectionLiterals.<Stop>newArrayList(_stop, _stop_1)));
      it.setBackgroundPaint(_linearGradient);
    };
    return ObjectExtensions.<RectangleBorderPane>operator_doubleArrow(_rectangleBorderPane, _function);
  }
  
  @Override
  protected Anchors createAnchors() {
    return new RoundedRectangleAnchors(this, 6, 6);
  }
  
  @Override
  public void doActivate() {
    super.doActivate();
    IMappedElementDescriptor<T> _domainObjectDescriptor = this.getDomainObjectDescriptor();
    LazyConnectionMappingBehavior.<T>addLazyBehavior(this, _domainObjectDescriptor);
    NodeReconcileBehavior _nodeReconcileBehavior = new NodeReconcileBehavior(this);
    this.addBehavior(_nodeReconcileBehavior);
  }
  
  @Override
  public List<Side> getButtonSides(final ConnectionMapping<?> mapping) {
    return Collections.<Side>unmodifiableList(CollectionLiterals.<Side>newArrayList(Side.TOP, Side.BOTTOM, Side.LEFT, Side.RIGHT));
  }
  
  public void populate(final ModelElementImpl modelElement) {
    super.populate(modelElement);
  }
}
