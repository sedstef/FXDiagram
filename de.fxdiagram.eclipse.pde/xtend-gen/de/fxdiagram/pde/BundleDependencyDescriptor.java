package de.fxdiagram.pde;

import com.google.common.base.Objects;
import de.fxdiagram.annotations.properties.ModelNode;
import de.fxdiagram.core.model.ModelElementImpl;
import de.fxdiagram.core.model.ToString;
import de.fxdiagram.mapping.AbstractMappedElementDescriptor;
import de.fxdiagram.pde.BundleDependency;
import de.fxdiagram.pde.BundleUtil;
import java.util.NoSuchElementException;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

@ModelNode({ "kind", "ownerSymbolicName", "ownerVersion", "importSymbolicName", "importVersionRange" })
@SuppressWarnings("all")
public class BundleDependencyDescriptor extends AbstractMappedElementDescriptor<BundleDependency> {
  public BundleDependencyDescriptor(final BundleDependency.Kind kind, final String ownerSymbolicName, final String ownerVersion, final String importSymbolicName, final String importVersionRange, final String mappingConfigID, final String mappingID) {
    super(mappingConfigID, mappingID);
    this.kindProperty.set(kind);
    this.ownerSymbolicNameProperty.set(ownerSymbolicName);
    this.ownerVersionProperty.set(ownerVersion);
    this.importSymbolicNameProperty.set(importSymbolicName);
    this.importVersionRangeProperty.set(importVersionRange);
  }
  
  @Override
  public <U extends Object> U withDomainObject(final Function1<? super BundleDependency, ? extends U> lambda) {
    U _xblockexpression = null;
    {
      final BundleDependency dependency = BundleUtil.findBundleDependency(this.getKind(), this.getOwnerSymbolicName(), this.getOwnerVersion(), this.getImportSymbolicName(), this.getImportVersionRange());
      if ((dependency == null)) {
        String _ownerSymbolicName = this.getOwnerSymbolicName();
        String _plus = ("Bundle dependency from " + _ownerSymbolicName);
        String _plus_1 = (_plus + " to ");
        String _importSymbolicName = this.getImportSymbolicName();
        String _plus_2 = (_plus_1 + _importSymbolicName);
        String _plus_3 = (_plus_2 + " not found");
        throw new NoSuchElementException(_plus_3);
      }
      _xblockexpression = lambda.apply(dependency);
    }
    return _xblockexpression;
  }
  
  @Override
  public String getName() {
    String _ownerSymbolicName = this.getOwnerSymbolicName();
    String _plus = (_ownerSymbolicName + "->");
    String _importSymbolicName = this.getImportSymbolicName();
    return (_plus + _importSymbolicName);
  }
  
  @Override
  public Object openInEditor(final boolean select) {
    return null;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if ((obj instanceof BundleDependencyDescriptor)) {
      return (((((super.equals(obj) && Objects.equal(((BundleDependencyDescriptor)obj).getKind(), this.getKind())) && Objects.equal(((BundleDependencyDescriptor)obj).getOwnerSymbolicName(), this.getOwnerSymbolicName())) && Objects.equal(((BundleDependencyDescriptor)obj).getOwnerVersion(), this.getOwnerVersion())) && Objects.equal(((BundleDependencyDescriptor)obj).getImportSymbolicName(), this.getImportSymbolicName())) && Objects.equal(((BundleDependencyDescriptor)obj).getImportVersionRange(), this.getImportVersionRange()));
    } else {
      return false;
    }
  }
  
  @Override
  public int hashCode() {
    int _hashCode = super.hashCode();
    int _hashCode_1 = this.getKind().hashCode();
    int _multiply = (71 * _hashCode_1);
    int _plus = (_hashCode + _multiply);
    int _hashCode_2 = this.getOwnerSymbolicName().hashCode();
    int _multiply_1 = (73 * _hashCode_2);
    int _plus_1 = (_plus + _multiply_1);
    int _hashCode_3 = this.getOwnerVersion().hashCode();
    int _multiply_2 = (79 * _hashCode_3);
    int _plus_2 = (_plus_1 + _multiply_2);
    int _hashCode_4 = this.getImportSymbolicName().hashCode();
    int _multiply_3 = (83 * _hashCode_4);
    int _plus_3 = (_plus_2 + _multiply_3);
    int _hashCode_5 = this.getImportVersionRange().hashCode();
    int _multiply_4 = (89 * _hashCode_5);
    return (_plus_3 + _multiply_4);
  }
  
  /**
   * Automatically generated by @ModelNode. Needed for deserialization.
   */
  public BundleDependencyDescriptor() {
  }
  
  public void populate(final ModelElementImpl modelElement) {
    super.populate(modelElement);
    modelElement.addProperty(kindProperty, BundleDependency.Kind.class);
    modelElement.addProperty(ownerSymbolicNameProperty, String.class);
    modelElement.addProperty(ownerVersionProperty, String.class);
    modelElement.addProperty(importSymbolicNameProperty, String.class);
    modelElement.addProperty(importVersionRangeProperty, String.class);
  }
  
  public void postLoad() {
    
  }
  
  public String toString() {
    return ToString.toString(this);
  }
  
  private ReadOnlyObjectWrapper<BundleDependency.Kind> kindProperty = new ReadOnlyObjectWrapper<BundleDependency.Kind>(this, "kind");
  
  public BundleDependency.Kind getKind() {
    return this.kindProperty.get();
  }
  
  public ReadOnlyObjectProperty<BundleDependency.Kind> kindProperty() {
    return this.kindProperty.getReadOnlyProperty();
  }
  
  private ReadOnlyStringWrapper ownerSymbolicNameProperty = new ReadOnlyStringWrapper(this, "ownerSymbolicName");
  
  public String getOwnerSymbolicName() {
    return this.ownerSymbolicNameProperty.get();
  }
  
  public ReadOnlyStringProperty ownerSymbolicNameProperty() {
    return this.ownerSymbolicNameProperty.getReadOnlyProperty();
  }
  
  private ReadOnlyStringWrapper ownerVersionProperty = new ReadOnlyStringWrapper(this, "ownerVersion");
  
  public String getOwnerVersion() {
    return this.ownerVersionProperty.get();
  }
  
  public ReadOnlyStringProperty ownerVersionProperty() {
    return this.ownerVersionProperty.getReadOnlyProperty();
  }
  
  private ReadOnlyStringWrapper importSymbolicNameProperty = new ReadOnlyStringWrapper(this, "importSymbolicName");
  
  public String getImportSymbolicName() {
    return this.importSymbolicNameProperty.get();
  }
  
  public ReadOnlyStringProperty importSymbolicNameProperty() {
    return this.importSymbolicNameProperty.getReadOnlyProperty();
  }
  
  private ReadOnlyStringWrapper importVersionRangeProperty = new ReadOnlyStringWrapper(this, "importVersionRange");
  
  public String getImportVersionRange() {
    return this.importVersionRangeProperty.get();
  }
  
  public ReadOnlyStringProperty importVersionRangeProperty() {
    return this.importVersionRangeProperty.getReadOnlyProperty();
  }
}
