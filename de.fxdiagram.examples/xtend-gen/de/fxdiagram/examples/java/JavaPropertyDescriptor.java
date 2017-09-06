package de.fxdiagram.examples.java;

import de.fxdiagram.annotations.properties.ModelNode;
import de.fxdiagram.core.model.CachedDomainObjectDescriptor;
import de.fxdiagram.core.model.ModelElementImpl;
import de.fxdiagram.core.model.ToString;
import de.fxdiagram.examples.java.JavaModelProvider;
import de.fxdiagram.examples.java.JavaProperty;
import org.eclipse.xtext.xbase.lib.Exceptions;

@ModelNode
@SuppressWarnings("all")
public class JavaPropertyDescriptor extends CachedDomainObjectDescriptor<JavaProperty> {
  public JavaPropertyDescriptor(final JavaProperty it, final JavaModelProvider provider) {
    super(it, ((it.getType().getCanonicalName() + " ") + it.getName()), provider);
  }
  
  @Override
  public JavaProperty resolveDomainObject() {
    try {
      JavaProperty _xblockexpression = null;
      {
        final String[] split = this.getId().split(" ");
        String _get = split[1];
        Class<?> _forName = Class.forName(split[0]);
        _xblockexpression = new JavaProperty(_get, _forName);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Automatically generated by @ModelNode. Needed for deserialization.
   */
  public JavaPropertyDescriptor() {
  }
  
  public void populate(final ModelElementImpl modelElement) {
    super.populate(modelElement);
  }
  
  public void postLoad() {
    
  }
  
  public String toString() {
    return ToString.toString(this);
  }
}
