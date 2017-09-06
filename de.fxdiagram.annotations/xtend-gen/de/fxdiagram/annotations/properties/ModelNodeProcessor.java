package de.fxdiagram.annotations.properties;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import de.fxdiagram.annotations.properties.ModelNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.Property;
import javafx.beans.property.StringProperty;
import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ModelNodeProcessor extends AbstractClassProcessor {
  @Extension
  private TransformationContext context;
  
  @Override
  public void doTransform(final MutableClassDeclaration annotatedClass, final TransformationContext context) {
    this.context = context;
    final Type modelNodeAnnotationType = this.context.findTypeGlobally(ModelNode.class);
    final AnnotationReference modelAnnotation = annotatedClass.findAnnotation(modelNodeAnnotationType);
    final ArrayList<String> validPropertyNames = CollectionLiterals.<String>newArrayList();
    final Consumer<String> _function = (String it) -> {
      final MemberDeclaration accessor = this.getPropertyAccessor(annotatedClass, it, true);
      if ((accessor == null)) {
        this.context.addWarning(modelAnnotation, (("Cannot find JavaFX property \'" + it) + "\'"));
      }
      validPropertyNames.add(it);
    };
    ((List<String>)Conversions.doWrapArray(modelAnnotation.getStringArrayValue("value"))).forEach(_function);
    final MutableConstructorDeclaration existingNoArgConstructor = annotatedClass.findDeclaredConstructor();
    if ((existingNoArgConstructor == null)) {
      final Procedure1<MutableConstructorDeclaration> _function_1 = (MutableConstructorDeclaration it) -> {
        it.setDocComment("Automatically generated by @ModelNode. Needed for deserialization.");
      };
      annotatedClass.addConstructor(_function_1);
    }
    final TypeReference modelProviderType = this.context.newTypeReference("de.fxdiagram.core.model.XModelProvider");
    boolean _isAssignableFrom = modelProviderType.getType().isAssignableFrom(annotatedClass);
    boolean _not = (!_isAssignableFrom);
    if (_not) {
      Iterable<? extends TypeReference> _implementedInterfaces = annotatedClass.getImplementedInterfaces();
      Iterable<TypeReference> _plus = Iterables.<TypeReference>concat(_implementedInterfaces, Collections.<TypeReference>unmodifiableList(CollectionLiterals.<TypeReference>newArrayList(modelProviderType)));
      annotatedClass.setImplementedInterfaces(_plus);
    }
    final Procedure1<MutableMethodDeclaration> _function_2 = (MutableMethodDeclaration it) -> {
      it.addParameter("modelElement", this.context.newTypeReference("de.fxdiagram.core.model.ModelElementImpl"));
      Object _value = modelAnnotation.getValue("inherit");
      final boolean isInheritAttribtueSet = (!Objects.equal(_value, Boolean.FALSE));
      final TypeReference superClass = annotatedClass.getExtendedClass();
      boolean _and = false;
      if (!isInheritAttribtueSet) {
        _and = false;
      } else {
        boolean _xifexpression = false;
        if ((superClass != null)) {
          boolean _xblockexpression = false;
          {
            final boolean isSuperImplementsModelProvider = modelProviderType.isAssignableFrom(superClass);
            Type _type = superClass.getType();
            AnnotationReference _findAnnotation = ((TypeDeclaration) _type).findAnnotation(modelNodeAnnotationType);
            final boolean isSuperHasModelNodeAnnotation = (_findAnnotation != null);
            _xblockexpression = (isSuperImplementsModelProvider || isSuperHasModelNodeAnnotation);
          }
          _xifexpression = _xblockexpression;
        } else {
          _xifexpression = false;
        }
        _and = _xifexpression;
      }
      final boolean isInherit = _and;
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          {
            if (isInherit) {
              _builder.append("super.populate(modelElement);");
            }
          }
          _builder.newLineIfNotEmpty();
          {
            final Function1<String, MemberDeclaration> _function = (String it_1) -> {
              return ModelNodeProcessor.this.getPropertyAccessor(annotatedClass, it_1, true);
            };
            List<MemberDeclaration> _map = ListExtensions.<String, MemberDeclaration>map(validPropertyNames, _function);
            for(final MemberDeclaration accessor : _map) {
              _builder.append("modelElement.addProperty(");
              String _call = ModelNodeProcessor.this.getCall(accessor);
              _builder.append(_call);
              _builder.append(", ");
              TypeReference _newTypeReference = ModelNodeProcessor.this.context.newTypeReference(ModelNodeProcessor.this.getComponentType(accessor).getType());
              _builder.append(_newTypeReference);
              _builder.append(".class);");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      };
      it.setBody(_client);
    };
    annotatedClass.addMethod("populate", _function_2);
    final Function1<MutableMethodDeclaration, Boolean> _function_3 = (MutableMethodDeclaration it) -> {
      return Boolean.valueOf((Objects.equal(it.getSimpleName(), "postLoad") && IterableExtensions.isEmpty(it.getParameters())));
    };
    boolean _exists = IterableExtensions.exists(annotatedClass.getDeclaredMethods(), _function_3);
    boolean _not_1 = (!_exists);
    if (_not_1) {
      final Procedure1<MutableMethodDeclaration> _function_4 = (MutableMethodDeclaration it) -> {
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          }
        };
        it.setBody(_client);
      };
      annotatedClass.addMethod("postLoad", _function_4);
    }
    final Function1<MutableMethodDeclaration, Boolean> _function_5 = (MutableMethodDeclaration it) -> {
      return Boolean.valueOf((Objects.equal(it.getSimpleName(), "toString") && IterableExtensions.isEmpty(it.getParameters())));
    };
    boolean _exists_1 = IterableExtensions.exists(annotatedClass.getDeclaredMethods(), _function_5);
    boolean _not_2 = (!_exists_1);
    if (_not_2) {
      final Procedure1<MutableMethodDeclaration> _function_6 = (MutableMethodDeclaration it) -> {
        it.setReturnType(this.context.newTypeReference(String.class));
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("return ");
            TypeReference _newTypeReference = ModelNodeProcessor.this.context.newTypeReference("de.fxdiagram.core.model.ToString");
            _builder.append(_newTypeReference);
            _builder.append(".toString(this);");
            _builder.newLineIfNotEmpty();
          }
        };
        it.setBody(_client);
      };
      annotatedClass.addMethod("toString", _function_6);
    }
  }
  
  protected CharSequence getHierarchy(final ClassDeclaration clazz) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Class: ");
    String _simpleName = clazz.getSimpleName();
    _builder.append(_simpleName);
    _builder.newLineIfNotEmpty();
    {
      Iterable<? extends MethodDeclaration> _declaredMethods = clazz.getDeclaredMethods();
      for(final MethodDeclaration m : _declaredMethods) {
        _builder.append("\t");
        String _simpleName_1 = m.getSimpleName();
        _builder.append(_simpleName_1, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    CharSequence _elvis = null;
    TypeReference _extendedClass = clazz.getExtendedClass();
    Type _type = null;
    if (_extendedClass!=null) {
      _type=_extendedClass.getType();
    }
    CharSequence _hierarchy = null;
    if (((ClassDeclaration) _type)!=null) {
      Type _type_1 = null;
      if (_extendedClass!=null) {
        _type_1=_extendedClass.getType();
      }
      _hierarchy=this.getHierarchy(((ClassDeclaration) _type_1));
    }
    if (_hierarchy != null) {
      _elvis = _hierarchy;
    } else {
      _elvis = "";
    }
    _builder.append(_elvis);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected MemberDeclaration getPropertyAccessor(final ClassDeclaration clazz, final String propertyName, final boolean allowPrivate) {
    FieldDeclaration _elvis = null;
    FieldDeclaration _findDeclaredField = clazz.findDeclaredField(propertyName);
    if (_findDeclaredField != null) {
      _elvis = _findDeclaredField;
    } else {
      FieldDeclaration _findDeclaredField_1 = clazz.findDeclaredField((propertyName + "Property"));
      _elvis = _findDeclaredField_1;
    }
    final FieldDeclaration field = _elvis;
    if (((field != null) && (allowPrivate || (!Objects.equal(field.getVisibility(), Visibility.PRIVATE))))) {
      return field;
    }
    MethodDeclaration _elvis_1 = null;
    MethodDeclaration _elvis_2 = null;
    MethodDeclaration _findDeclaredMethod = clazz.findDeclaredMethod(propertyName);
    if (_findDeclaredMethod != null) {
      _elvis_2 = _findDeclaredMethod;
    } else {
      MethodDeclaration _findDeclaredMethod_1 = clazz.findDeclaredMethod((propertyName + "Property"));
      _elvis_2 = _findDeclaredMethod_1;
    }
    if (_elvis_2 != null) {
      _elvis_1 = _elvis_2;
    } else {
      String _firstUpper = StringExtensions.toFirstUpper(propertyName);
      String _plus = ("get" + _firstUpper);
      MethodDeclaration _findDeclaredMethod_2 = clazz.findDeclaredMethod(_plus);
      _elvis_1 = _findDeclaredMethod_2;
    }
    final MethodDeclaration method = _elvis_1;
    if (((method != null) && (allowPrivate || (!Objects.equal(method.getVisibility(), Visibility.PRIVATE))))) {
      return method;
    }
    TypeReference _extendedClass = clazz.getExtendedClass();
    boolean _tripleNotEquals = (_extendedClass != null);
    if (_tripleNotEquals) {
      Type _type = clazz.getExtendedClass().getType();
      return this.getPropertyAccessor(((ClassDeclaration) _type), propertyName, false);
    }
    return null;
  }
  
  protected TypeReference getComponentType(final MemberDeclaration member) {
    TypeReference _switchResult = null;
    boolean _matched = false;
    if (member instanceof MethodDeclaration) {
      _matched=true;
      _switchResult = ((MethodDeclaration)member).getReturnType();
    }
    if (!_matched) {
      if (member instanceof FieldDeclaration) {
        _matched=true;
        _switchResult = ((FieldDeclaration)member).getType();
      }
    }
    if (!_matched) {
      _switchResult = this.context.getObject();
    }
    return this.getComponentType(_switchResult);
  }
  
  protected String getCall(final MemberDeclaration member) {
    String _simpleName = member.getSimpleName();
    String _xifexpression = null;
    if ((member instanceof MethodDeclaration)) {
      _xifexpression = "()";
    } else {
      _xifexpression = "";
    }
    return (_simpleName + _xifexpression);
  }
  
  protected TypeReference getComponentType(final TypeReference it) {
    boolean _isAssignableFrom = this.context.newTypeReference(Property.class, this.context.newWildcardTypeReference()).isAssignableFrom(it);
    if (_isAssignableFrom) {
      TypeReference _elvis = null;
      TypeReference _elvis_1 = null;
      TypeReference _elvis_2 = null;
      TypeReference _elvis_3 = null;
      TypeReference _elvis_4 = null;
      TypeReference _elvis_5 = null;
      TypeReference _elvis_6 = null;
      TypeReference _elvis_7 = null;
      TypeReference _elvis_8 = null;
      TypeReference _elvis_9 = null;
      TypeReference _elvis_10 = null;
      TypeReference _elvis_11 = null;
      TypeReference _elvis_12 = null;
      TypeReference _elvis_13 = null;
      TypeReference _isListType = this.isListType(it, Double.class);
      if (_isListType != null) {
        _elvis_13 = _isListType;
      } else {
        TypeReference _isListType_1 = this.isListType(it, String.class);
        _elvis_13 = _isListType_1;
      }
      if (_elvis_13 != null) {
        _elvis_12 = _elvis_13;
      } else {
        TypeReference _isListType_2 = this.isListType(it, Integer.class);
        _elvis_12 = _isListType_2;
      }
      if (_elvis_12 != null) {
        _elvis_11 = _elvis_12;
      } else {
        TypeReference _isListType_3 = this.isListType(it, Boolean.class);
        _elvis_11 = _isListType_3;
      }
      if (_elvis_11 != null) {
        _elvis_10 = _elvis_11;
      } else {
        TypeReference _isListType_4 = this.isListType(it, Long.class);
        _elvis_10 = _isListType_4;
      }
      if (_elvis_10 != null) {
        _elvis_9 = _elvis_10;
      } else {
        TypeReference _isListType_5 = this.isListType(it, Float.class);
        _elvis_9 = _isListType_5;
      }
      if (_elvis_9 != null) {
        _elvis_8 = _elvis_9;
      } else {
        TypeReference _isListType_6 = this.isListType(it, Enum.class);
        _elvis_8 = _isListType_6;
      }
      if (_elvis_8 != null) {
        _elvis_7 = _elvis_8;
      } else {
        TypeReference _isListType_7 = this.isListType(it, Object.class);
        _elvis_7 = _isListType_7;
      }
      if (_elvis_7 != null) {
        _elvis_6 = _elvis_7;
      } else {
        TypeReference _isType = this.isType(it, DoubleProperty.class, Double.class);
        _elvis_6 = _isType;
      }
      if (_elvis_6 != null) {
        _elvis_5 = _elvis_6;
      } else {
        TypeReference _isType_1 = this.isType(it, StringProperty.class, String.class);
        _elvis_5 = _isType_1;
      }
      if (_elvis_5 != null) {
        _elvis_4 = _elvis_5;
      } else {
        TypeReference _isType_2 = this.isType(it, IntegerProperty.class, Integer.class);
        _elvis_4 = _isType_2;
      }
      if (_elvis_4 != null) {
        _elvis_3 = _elvis_4;
      } else {
        TypeReference _isType_3 = this.isType(it, BooleanProperty.class, Boolean.class);
        _elvis_3 = _isType_3;
      }
      if (_elvis_3 != null) {
        _elvis_2 = _elvis_3;
      } else {
        TypeReference _isType_4 = this.isType(it, LongProperty.class, Long.class);
        _elvis_2 = _isType_4;
      }
      if (_elvis_2 != null) {
        _elvis_1 = _elvis_2;
      } else {
        TypeReference _isType_5 = this.isType(it, FloatProperty.class, Float.class);
        _elvis_1 = _isType_5;
      }
      if (_elvis_1 != null) {
        _elvis = _elvis_1;
      } else {
        TypeReference _head = IterableExtensions.<TypeReference>head(it.getActualTypeArguments());
        _elvis = _head;
      }
      return _elvis;
    } else {
      return null;
    }
  }
  
  protected TypeReference isType(final TypeReference typeRef, final Class<? extends Property<?>> propertyType, final Class<?> clazz) {
    boolean _isAssignableFrom = this.context.newTypeReference(propertyType).isAssignableFrom(typeRef);
    if (_isAssignableFrom) {
      return this.context.newTypeReference(clazz);
    } else {
      return null;
    }
  }
  
  protected TypeReference isListType(final TypeReference typeRef, final Class<?> clazz) {
    final TypeReference componentType = this.context.newTypeReference(clazz);
    boolean _isAssignableFrom = this.context.newTypeReference(ListProperty.class, componentType).isAssignableFrom(typeRef);
    if (_isAssignableFrom) {
      return componentType;
    } else {
      return null;
    }
  }
}
