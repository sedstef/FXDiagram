package de.fxdiagram.examples.slides;

import de.fxdiagram.annotations.properties.ModelNode;
import de.fxdiagram.core.XNode;
import de.fxdiagram.core.XRoot;
import de.fxdiagram.core.extensions.CoreExtensions;
import de.fxdiagram.core.model.DomainObjectHandle;
import de.fxdiagram.core.model.ModelElementImpl;
import de.fxdiagram.core.tools.actions.ZoomToFitAction;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@ModelNode({ "layoutX", "layoutY", "domainObject", "width", "height" })
@SuppressWarnings("all")
public class Slide extends XNode {
  private ImageView imageView;
  
  public Slide(final String name) {
    super(name);
  }
  
  public Slide(final String name, final Image backgroundImage) {
    this(name);
    this.setBackgroundImage(backgroundImage);
  }
  
  protected StackPane createNode() {
    StackPane _stackPane = new StackPane();
    final Procedure1<StackPane> _function = new Procedure1<StackPane>() {
      public void apply(final StackPane it) {
        ObservableList<Node> _children = it.getChildren();
        ImageView _imageView = new ImageView();
        final Procedure1<ImageView> _function = new Procedure1<ImageView>() {
          public void apply(final ImageView it) {
            ColorAdjust _colorAdjust = new ColorAdjust();
            final Procedure1<ColorAdjust> _function = new Procedure1<ColorAdjust>() {
              public void apply(final ColorAdjust it) {
                it.setBrightness((-0.5));
                it.setSaturation(0);
                it.setContrast((-0.1));
              }
            };
            ColorAdjust _doubleArrow = ObjectExtensions.<ColorAdjust>operator_doubleArrow(_colorAdjust, _function);
            it.setEffect(_doubleArrow);
          }
        };
        ImageView _doubleArrow = ObjectExtensions.<ImageView>operator_doubleArrow(_imageView, _function);
        ImageView _imageView_1 = Slide.this.imageView = _doubleArrow;
        _children.add(_imageView_1);
      }
    };
    return ObjectExtensions.<StackPane>operator_doubleArrow(_stackPane, _function);
  }
  
  public void doActivate() {
    super.doActivate();
    Image _backgroundImage = this.getBackgroundImage();
    this.imageView.setImage(_backgroundImage);
    ZoomToFitAction _zoomToFitAction = new ZoomToFitAction();
    XRoot _root = CoreExtensions.getRoot(this);
    _zoomToFitAction.perform(_root);
  }
  
  public StackPane getStackPane() {
    Node _node = this.getNode();
    return ((StackPane) _node);
  }
  
  public void selectionFeedback(final boolean isSelected) {
  }
  
  /**
   * Automatically generated by @ModelNode. Needed for deserialization.
   */
  public Slide() {
  }
  
  public void populate(final ModelElementImpl modelElement) {
    modelElement.addProperty(layoutXProperty(), Double.class);
    modelElement.addProperty(layoutYProperty(), Double.class);
    modelElement.addProperty(domainObjectProperty(), DomainObjectHandle.class);
    modelElement.addProperty(widthProperty(), Double.class);
    modelElement.addProperty(heightProperty(), Double.class);
  }
  
  private SimpleObjectProperty<Image> backgroundImageProperty = new SimpleObjectProperty<Image>(this, "backgroundImage");
  
  public Image getBackgroundImage() {
    return this.backgroundImageProperty.get();
  }
  
  public void setBackgroundImage(final Image backgroundImage) {
    this.backgroundImageProperty.set(backgroundImage);
  }
  
  public ObjectProperty<Image> backgroundImageProperty() {
    return this.backgroundImageProperty;
  }
}