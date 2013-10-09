package de.fxdiagram.examples.neonsign

import de.fxdiagram.core.XNode
import de.fxdiagram.lib.nodes.FlipNode
import de.fxdiagram.lib.nodes.RectangleBorderPane
import javafx.animation.KeyFrame
import javafx.animation.KeyValue
import javafx.animation.Timeline
import javafx.geometry.Insets
import javafx.scene.control.TextField
import javafx.scene.effect.Blend
import javafx.scene.effect.BlendMode
import javafx.scene.effect.Bloom
import javafx.scene.effect.InnerShadow
import javafx.scene.layout.StackPane
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.scene.text.Text
import javafx.scene.text.TextAlignment

import static de.fxdiagram.core.extensions.UriExtensions.*

import static extension javafx.scene.layout.VBox.*
import static extension javafx.util.Duration.*

class NeonSignNode extends XNode {

	TextField textField

	Text neonText

	new() {
		super('Neon Sign')
		node = new FlipNode => [
			front = new RectangleBorderPane => [
				children += new Text => [
					text = key
					StackPane.setMargin(it, new Insets(10, 20, 10, 20))
				]
			]
			back = neonSign
			flipOnDoubleClick = true
		]
	}

	protected def getNeonSign() {
		new VBox => [
			style = '''
				-fx-background-image: url("«toURI(this, 'brick.jpg')»");
			'''
			children += textField = new TextField => [ // text input widget
				text = 'JavaFX loves Xtend'
				margin = new Insets(10, 40, 10, 40)
			]
			children += neonText = new Text => [          // neon text
				textProperty.bind(textField.textProperty) // databinding
				wrappingWidth = 580                       // text placement
				textAlignment = TextAlignment.CENTER
				rotate = -7
				font = Font.font('Nanum Pen Script', 100) // font and color
				fill = Color.web('#feeb42')
				effect = new Blend => [                   // neon effect
					mode = BlendMode.MULTIPLY
					topInput = new Bloom
					bottomInput = new InnerShadow => [
						color = Color.web('#f13a00')
						radius = 5
						choke = 0.4
					]
				]
			]
			onMouseClicked = [                            // flickering animation
				new Timeline => [
					cycleCount = 20
					keyFrames += new KeyFrame(10.millis, new KeyValue(neonText.opacityProperty, 0.45))
					keyFrames += new KeyFrame(20.millis, new KeyValue(neonText.opacityProperty, 0.95))
					keyFrames += new KeyFrame(40.millis, new KeyValue(neonText.opacityProperty, 0.65))
					keyFrames += new KeyFrame(50.millis, new KeyValue(neonText.opacityProperty, 1))
					play
				]
			]
		]
	}
}
