package de.fxdiagram.annotations.test;

import com.google.common.collect.Iterables;
import de.fxdiagram.annotations.test.Modeltest4;
import de.fxdiagram.core.model.ModelLoad;
import de.fxdiagram.core.model.ModelSave;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Collections;
import javafx.collections.ObservableList;
import org.eclipse.xtend.core.compiler.batch.XtendCompilerTester;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class ModelNodeTest {
  @Test
  public void testLeaveImplicitConstructor() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import de.fxdiagram.annotations.properties.ModelNode");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@ModelNode");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import de.fxdiagram.annotations.properties.ModelNode;");
    _builder_1.newLine();
    _builder_1.append("import de.fxdiagram.core.model.ModelElementImpl;");
    _builder_1.newLine();
    _builder_1.append("import de.fxdiagram.core.model.ToString;");
    _builder_1.newLine();
    _builder_1.append("import de.fxdiagram.core.model.XModelProvider;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@ModelNode");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo implements XModelProvider {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void populate(final ModelElementImpl modelElement) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void postLoad() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public String toString() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return ToString.toString(this);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testCreateNoArgConstructor() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import de.fxdiagram.annotations.properties.ModelNode");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@ModelNode");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(String name) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import de.fxdiagram.annotations.properties.ModelNode;");
    _builder_1.newLine();
    _builder_1.append("import de.fxdiagram.core.model.ModelElementImpl;");
    _builder_1.newLine();
    _builder_1.append("import de.fxdiagram.core.model.ToString;");
    _builder_1.newLine();
    _builder_1.append("import de.fxdiagram.core.model.XModelProvider;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@ModelNode");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo implements XModelProvider {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Foo(final String name) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* Automatically generated by @ModelNode. Needed for deserialization.");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Foo() {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void populate(final ModelElementImpl modelElement) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void postLoad() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public String toString() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return ToString.toString(this);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testProperties() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import de.fxdiagram.annotations.properties.ModelNode");
    _builder.newLine();
    _builder.append("import javafx.beans.property.BooleanProperty");
    _builder.newLine();
    _builder.append("import javafx.beans.property.FloatProperty");
    _builder.newLine();
    _builder.append("import javafx.beans.property.IntegerProperty");
    _builder.newLine();
    _builder.append("import javafx.beans.property.LongProperty");
    _builder.newLine();
    _builder.append("import javafx.beans.property.ObjectProperty");
    _builder.newLine();
    _builder.append("import javafx.beans.property.StringProperty");
    _builder.newLine();
    _builder.append("import javafx.scene.shape.Polygon");
    _builder.newLine();
    _builder.append("import javafx.beans.property.ListProperty");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@ModelNode(\'layoutX\', \'string\', \'integer\', \'long\', \'bool\', \'unprecise\', \'names\', \'selfRef\') ");
    _builder.newLine();
    _builder.append("abstract class ModelTest extends Polygon {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("IntegerProperty integer");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("LongProperty longProperty");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("BooleanProperty bool");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("FloatProperty unprecise");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ObjectProperty<String> stringProperty\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("StringProperty string1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ObjectProperty<ModelTest> selfRef");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ListProperty<String> names\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import de.fxdiagram.annotations.properties.ModelNode;");
    _builder_1.newLine();
    _builder_1.append("import de.fxdiagram.core.model.ModelElementImpl;");
    _builder_1.newLine();
    _builder_1.append("import de.fxdiagram.core.model.ToString;");
    _builder_1.newLine();
    _builder_1.append("import de.fxdiagram.core.model.XModelProvider;");
    _builder_1.newLine();
    _builder_1.append("import javafx.beans.property.BooleanProperty;");
    _builder_1.newLine();
    _builder_1.append("import javafx.beans.property.FloatProperty;");
    _builder_1.newLine();
    _builder_1.append("import javafx.beans.property.IntegerProperty;");
    _builder_1.newLine();
    _builder_1.append("import javafx.beans.property.ListProperty;");
    _builder_1.newLine();
    _builder_1.append("import javafx.beans.property.LongProperty;");
    _builder_1.newLine();
    _builder_1.append("import javafx.beans.property.ObjectProperty;");
    _builder_1.newLine();
    _builder_1.append("import javafx.beans.property.StringProperty;");
    _builder_1.newLine();
    _builder_1.append("import javafx.scene.shape.Polygon;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@ModelNode({ \"layoutX\", \"string\", \"integer\", \"long\", \"bool\", \"unprecise\", \"names\", \"selfRef\" })");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public abstract class ModelTest extends Polygon implements XModelProvider {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private IntegerProperty integer;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private LongProperty longProperty;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private BooleanProperty bool;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private FloatProperty unprecise;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private ObjectProperty<String> stringProperty;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private StringProperty string1;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private ObjectProperty<ModelTest> selfRef;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private ListProperty<String> names;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void populate(final ModelElementImpl modelElement) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("modelElement.addProperty(layoutXProperty(), Double.class);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("modelElement.addProperty(stringProperty, String.class);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("modelElement.addProperty(integer, Integer.class);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("modelElement.addProperty(longProperty, Long.class);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("modelElement.addProperty(bool, Boolean.class);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("modelElement.addProperty(unprecise, Float.class);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("modelElement.addProperty(names, String.class);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("modelElement.addProperty(selfRef, ModelTest.class);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void postLoad() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public String toString() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return ToString.toString(this);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testFxProperty() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import de.fxdiagram.annotations.properties.FxProperty");
    _builder.newLine();
    _builder.append("import de.fxdiagram.annotations.properties.ModelNode");
    _builder.newLine();
    _builder.append("import javafx.collections.FXCollections");
    _builder.newLine();
    _builder.append("import javafx.collections.ObservableList");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@ModelNode(\'myDouble\', \'myString\', \'myObject\', \'myList\')");
    _builder.newLine();
    _builder.append("class ActiveAnnotationsTest {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@FxProperty double myDouble");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@FxProperty String myString");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@FxProperty Object myObject = new Object");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@FxProperty ObservableList<String> myList = FXCollections.observableArrayList");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import de.fxdiagram.annotations.properties.ModelNode;");
    _builder_1.newLine();
    _builder_1.append("import de.fxdiagram.core.model.ModelElementImpl;");
    _builder_1.newLine();
    _builder_1.append("import de.fxdiagram.core.model.ToString;");
    _builder_1.newLine();
    _builder_1.append("import de.fxdiagram.core.model.XModelProvider;");
    _builder_1.newLine();
    _builder_1.append("import javafx.beans.property.DoubleProperty;");
    _builder_1.newLine();
    _builder_1.append("import javafx.beans.property.ListProperty;");
    _builder_1.newLine();
    _builder_1.append("import javafx.beans.property.ObjectProperty;");
    _builder_1.newLine();
    _builder_1.append("import javafx.beans.property.SimpleDoubleProperty;");
    _builder_1.newLine();
    _builder_1.append("import javafx.beans.property.SimpleListProperty;");
    _builder_1.newLine();
    _builder_1.append("import javafx.beans.property.SimpleObjectProperty;");
    _builder_1.newLine();
    _builder_1.append("import javafx.beans.property.SimpleStringProperty;");
    _builder_1.newLine();
    _builder_1.append("import javafx.beans.property.StringProperty;");
    _builder_1.newLine();
    _builder_1.append("import javafx.collections.FXCollections;");
    _builder_1.newLine();
    _builder_1.append("import javafx.collections.ObservableList;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@ModelNode({ \"myDouble\", \"myString\", \"myObject\", \"myList\" })");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class ActiveAnnotationsTest implements XModelProvider {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void populate(final ModelElementImpl modelElement) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("modelElement.addProperty(myDoubleProperty, Double.class);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("modelElement.addProperty(myStringProperty, String.class);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("modelElement.addProperty(myObjectProperty, Object.class);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("modelElement.addProperty(myListProperty, String.class);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void postLoad() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public String toString() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return ToString.toString(this);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private SimpleDoubleProperty myDoubleProperty = new SimpleDoubleProperty(this, \"myDouble\");");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public double getMyDouble() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this.myDoubleProperty.get();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void setMyDouble(final double myDouble) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("this.myDoubleProperty.set(myDouble);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public DoubleProperty myDoubleProperty() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this.myDoubleProperty;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private SimpleStringProperty myStringProperty = new SimpleStringProperty(this, \"myString\");");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public String getMyString() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this.myStringProperty.get();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void setMyString(final String myString) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("this.myStringProperty.set(myString);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public StringProperty myStringProperty() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this.myStringProperty;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private SimpleObjectProperty<Object> myObjectProperty = new SimpleObjectProperty<Object>(this, \"myObject\",_initMyObject());");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private static final Object _initMyObject() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Object _object = new Object();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _object;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Object getMyObject() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this.myObjectProperty.get();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void setMyObject(final Object myObject) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("this.myObjectProperty.set(myObject);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public ObjectProperty<Object> myObjectProperty() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this.myObjectProperty;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private SimpleListProperty<String> myListProperty = new SimpleListProperty<String>(this, \"myList\",_initMyList());");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private static final ObservableList<String> _initMyList() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("ObservableList<String> _observableArrayList = FXCollections.<String>observableArrayList();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _observableArrayList;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public ObservableList<String> getMyList() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this.myListProperty.get();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public ListProperty<String> myListProperty() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this.myListProperty;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testInherit() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import de.fxdiagram.annotations.properties.ModelNode");
    _builder.newLine();
    _builder.append("import javafx.beans.property.BooleanProperty");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@ModelNode(#[\'bool\'])");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("BooleanProperty bool");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@ModelNode");
    _builder.newLine();
    _builder.append("class Bar extends Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("MULTIPLE FILES WERE GENERATED");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("File 1 : /myProject/xtend-gen/Bar.java");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import de.fxdiagram.annotations.properties.ModelNode;");
    _builder_1.newLine();
    _builder_1.append("import de.fxdiagram.core.model.ModelElementImpl;");
    _builder_1.newLine();
    _builder_1.append("import de.fxdiagram.core.model.ToString;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@ModelNode");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Bar extends Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void populate(final ModelElementImpl modelElement) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("super.populate(modelElement);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void postLoad() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public String toString() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return ToString.toString(this);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("File 2 : /myProject/xtend-gen/Foo.java");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import de.fxdiagram.annotations.properties.ModelNode;");
    _builder_1.newLine();
    _builder_1.append("import de.fxdiagram.core.model.ModelElementImpl;");
    _builder_1.newLine();
    _builder_1.append("import de.fxdiagram.core.model.ToString;");
    _builder_1.newLine();
    _builder_1.append("import de.fxdiagram.core.model.XModelProvider;");
    _builder_1.newLine();
    _builder_1.append("import javafx.beans.property.BooleanProperty;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@ModelNode({ \"bool\" })");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo implements XModelProvider {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private BooleanProperty bool;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void populate(final ModelElementImpl modelElement) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("modelElement.addProperty(bool, Boolean.class);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void postLoad() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public String toString() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return ToString.toString(this);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testNoInherit() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import de.fxdiagram.annotations.properties.ModelNode");
    _builder.newLine();
    _builder.append("import javafx.beans.property.BooleanProperty");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@ModelNode(#[\'bool\'])");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("BooleanProperty bool");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@ModelNode(inherit=false)");
    _builder.newLine();
    _builder.append("class Bar extends Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("MULTIPLE FILES WERE GENERATED");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("File 1 : /myProject/xtend-gen/Bar.java");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import de.fxdiagram.annotations.properties.ModelNode;");
    _builder_1.newLine();
    _builder_1.append("import de.fxdiagram.core.model.ModelElementImpl;");
    _builder_1.newLine();
    _builder_1.append("import de.fxdiagram.core.model.ToString;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@ModelNode(inherit = false)");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Bar extends Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void populate(final ModelElementImpl modelElement) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void postLoad() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public String toString() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return ToString.toString(this);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("File 2 : /myProject/xtend-gen/Foo.java");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import de.fxdiagram.annotations.properties.ModelNode;");
    _builder_1.newLine();
    _builder_1.append("import de.fxdiagram.core.model.ModelElementImpl;");
    _builder_1.newLine();
    _builder_1.append("import de.fxdiagram.core.model.ToString;");
    _builder_1.newLine();
    _builder_1.append("import de.fxdiagram.core.model.XModelProvider;");
    _builder_1.newLine();
    _builder_1.append("import javafx.beans.property.BooleanProperty;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@ModelNode({ \"bool\" })");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo implements XModelProvider {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private BooleanProperty bool;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void populate(final ModelElementImpl modelElement) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("modelElement.addProperty(bool, Boolean.class);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void postLoad() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public String toString() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return ToString.toString(this);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testNoToString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import de.fxdiagram.annotations.properties.ModelNode");
    _builder.newLine();
    _builder.append("import javafx.beans.property.BooleanProperty");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@ModelNode");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override toString() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("null");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import de.fxdiagram.annotations.properties.ModelNode;");
    _builder_1.newLine();
    _builder_1.append("import de.fxdiagram.core.model.ModelElementImpl;");
    _builder_1.newLine();
    _builder_1.append("import de.fxdiagram.core.model.XModelProvider;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@ModelNode");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo implements XModelProvider {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public String toString() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return null;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void populate(final ModelElementImpl modelElement) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void postLoad() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testNoPostLoad() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import de.fxdiagram.annotations.properties.ModelNode");
    _builder.newLine();
    _builder.append("import javafx.beans.property.BooleanProperty");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@ModelNode");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override postLoad() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import de.fxdiagram.annotations.properties.ModelNode;");
    _builder_1.newLine();
    _builder_1.append("import de.fxdiagram.core.model.ModelElementImpl;");
    _builder_1.newLine();
    _builder_1.append("import de.fxdiagram.core.model.ToString;");
    _builder_1.newLine();
    _builder_1.append("import de.fxdiagram.core.model.XModelProvider;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@ModelNode");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo implements XModelProvider {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void postLoad() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void populate(final ModelElementImpl modelElement) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public String toString() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return ToString.toString(this);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  protected void assertCompilesTo(final CharSequence source, final CharSequence target) {
    final XtendCompilerTester compilerTester = XtendCompilerTester.newXtendCompilerTester(this.getClass());
    compilerTester.assertCompilesTo(source, target);
  }
  
  @Test
  public void saveAndLoad() {
    final StringWriter out = new StringWriter();
    final ModelSave save = new ModelSave();
    Modeltest4 _modeltest4 = new Modeltest4();
    final Procedure1<Modeltest4> _function = (Modeltest4 it) -> {
      ObservableList<String> _fqn = it.getFqn();
      Iterables.<String>addAll(_fqn, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("foo", "bar", "baz")));
    };
    final Modeltest4 saveModel = ObjectExtensions.<Modeltest4>operator_doubleArrow(_modeltest4, _function);
    save.save(saveModel, out);
    final ModelLoad load = new ModelLoad();
    String _string = out.toString();
    final StringReader in = new StringReader(_string);
    final Object loadModel = load.load(in);
    Assert.assertTrue((loadModel instanceof Modeltest4));
    final Modeltest4 loadModel2 = ((Modeltest4) loadModel);
    Assert.assertEquals(saveModel.getFqn(), loadModel2.getFqn());
  }
}
