package de.fxdiagram.examples.ecore;

import de.fxdiagram.annotations.properties.ModelNode;
import de.fxdiagram.core.model.CachedDomainObjectDescriptor;
import de.fxdiagram.core.model.DomainObjectProvider;
import de.fxdiagram.core.model.ModelElementImpl;
import de.fxdiagram.core.model.ToString;
import de.fxdiagram.examples.ecore.EcoreDomainObjectProvider;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.xbase.lib.Extension;

@ModelNode
@SuppressWarnings("all")
public class EClassDescriptor extends CachedDomainObjectDescriptor<EClass> {
  public EClassDescriptor(final EClass eClass, @Extension final EcoreDomainObjectProvider provider) {
    super(eClass, provider.getId(eClass), provider);
  }
  
  @Override
  public String getName() {
    DomainObjectProvider _provider = this.getProvider();
    return ((EcoreDomainObjectProvider) _provider).getFqn(this.getDomainObject());
  }
  
  @Override
  public EClass resolveDomainObject() {
    EClass _xblockexpression = null;
    {
      final URI uri = URI.createURI(this.getId());
      final EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(uri.trimFragment().toString());
      final int posEquals = uri.fragment().indexOf("=");
      String _xifexpression = null;
      if ((posEquals == (-1))) {
        _xifexpression = uri.fragment();
      } else {
        _xifexpression = uri.fragment().substring(0, posEquals);
      }
      final String fragment = _xifexpression;
      EObject _eObject = ePackage.eResource().getEObject(fragment);
      _xblockexpression = ((EClass) _eObject);
    }
    return _xblockexpression;
  }
  
  /**
   * Automatically generated by @ModelNode. Needed for deserialization.
   */
  public EClassDescriptor() {
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
