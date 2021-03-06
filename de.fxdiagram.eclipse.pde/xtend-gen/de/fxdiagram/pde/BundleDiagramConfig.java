package de.fxdiagram.pde;

import com.google.common.base.Objects;
import de.fxdiagram.core.XConnection;
import de.fxdiagram.core.XNode;
import de.fxdiagram.core.anchors.CircleArrowHead;
import de.fxdiagram.core.anchors.LineArrowHead;
import de.fxdiagram.core.extensions.ButtonExtensions;
import de.fxdiagram.eclipse.mapping.AbstractEclipseDiagramConfig;
import de.fxdiagram.mapping.ConnectionLabelMapping;
import de.fxdiagram.mapping.ConnectionMapping;
import de.fxdiagram.mapping.IMappedElementDescriptor;
import de.fxdiagram.mapping.IMappedElementDescriptorProvider;
import de.fxdiagram.mapping.MappingAcceptor;
import de.fxdiagram.mapping.NodeHeadingMapping;
import de.fxdiagram.mapping.NodeLabelMapping;
import de.fxdiagram.mapping.NodeMapping;
import de.fxdiagram.mapping.shapes.BaseConnection;
import de.fxdiagram.mapping.shapes.BaseNodeHeadingLabel;
import de.fxdiagram.mapping.shapes.BaseNodeLabel;
import de.fxdiagram.pde.BundleDependency;
import de.fxdiagram.pde.BundleDescriptor;
import de.fxdiagram.pde.BundleDescriptorProvider;
import de.fxdiagram.pde.BundleNode;
import de.fxdiagram.pde.BundleUtil;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class BundleDiagramConfig extends AbstractEclipseDiagramConfig {
  @Override
  protected IMappedElementDescriptorProvider createDomainObjectProvider() {
    return new BundleDescriptorProvider();
  }
  
  private final NodeMapping<BundleDescription> pluginNode = new NodeMapping<BundleDescription>(this, "pluginNode", "Plug-in") {
    @Override
    public XNode createNode(final IMappedElementDescriptor<BundleDescription> descriptor) {
      return new BundleNode(((BundleDescriptor) descriptor));
    }
    
    @Override
    public void calls() {
      final Function1<BundleDescription, BundleDescription> _function = (BundleDescription it) -> {
        return it;
      };
      this.<BundleDescription>labelFor(BundleDiagramConfig.this.pluginSymbolicName, _function);
      final Function1<BundleDescription, BundleDescription> _function_1 = (BundleDescription it) -> {
        return it;
      };
      this.<BundleDescription>labelFor(BundleDiagramConfig.this.pluginVersion, _function_1);
      final Function1<BundleDescription, BundleDescription> _function_2 = (BundleDescription it) -> {
        return it;
      };
      this.<BundleDescription>labelFor(BundleDiagramConfig.this.pluginName, _function_2);
      final Function1<BundleDescription, BundleDescription> _function_3 = (BundleDescription it) -> {
        return it;
      };
      this.<BundleDescription>labelFor(BundleDiagramConfig.this.pluginProvider, _function_3);
      final Function1<BundleDescription, BundleDescription> _function_4 = (BundleDescription it) -> {
        return it;
      };
      this.<BundleDescription>labelFor(BundleDiagramConfig.this.pluginExecutionEnvironment, _function_4);
      final Function1<BundleDescription, Iterable<? extends BundleDependency>> _function_5 = (BundleDescription it) -> {
        return BundleUtil.getBundleDependencies(it);
      };
      final Function1<Side, Node> _function_6 = (Side it) -> {
        return ButtonExtensions.getArrowButton(it, "Add dependency");
      };
      this.<BundleDependency>outConnectionForEach(BundleDiagramConfig.this.dependencyConnection, _function_5).asButton(_function_6);
      final Function1<BundleDescription, Iterable<? extends BundleDependency>> _function_7 = (BundleDescription it) -> {
        return BundleUtil.getInverseBundleDependencies(it);
      };
      final Function1<Side, Node> _function_8 = (Side it) -> {
        return ButtonExtensions.getArrowButton(ButtonExtensions.invert(it), "Add inverse dependency");
      };
      this.<BundleDependency>inConnectionForEach(BundleDiagramConfig.this.inverseDependencyConnection, _function_7).asButton(_function_8);
    }
  };
  
  private final NodeHeadingMapping<BundleDescription> pluginSymbolicName = new NodeHeadingMapping<BundleDescription>(this, BundleNode.BUNDLE_SYMBOLIC_NAME) {
    @Override
    public BaseNodeHeadingLabel<BundleDescription> createLabel(final IMappedElementDescriptor<BundleDescription> descriptor, final BundleDescription bundle) {
      BaseNodeHeadingLabel<BundleDescription> _createLabel = super.createLabel(descriptor, bundle);
      final Procedure1<BaseNodeHeadingLabel<BundleDescription>> _function = (BaseNodeHeadingLabel<BundleDescription> it) -> {
        Text _text = it.getText();
        final Procedure1<Text> _function_1 = (Text it_1) -> {
          it_1.setText(bundle.getSymbolicName());
          boolean _isSingleton = bundle.isSingleton();
          if (_isSingleton) {
            String _family = it_1.getFont().getFamily();
            double _size = it_1.getFont().getSize();
            double _multiply = (_size * 1.1);
            it_1.setFont(Font.font(_family, FontWeight.BOLD, FontPosture.ITALIC, _multiply));
          } else {
            String _family_1 = it_1.getFont().getFamily();
            double _size_1 = it_1.getFont().getSize();
            double _multiply_1 = (_size_1 * 1.1);
            it_1.setFont(Font.font(_family_1, FontWeight.BOLD, _multiply_1));
          }
        };
        ObjectExtensions.<Text>operator_doubleArrow(_text, _function_1);
      };
      return ObjectExtensions.<BaseNodeHeadingLabel<BundleDescription>>operator_doubleArrow(_createLabel, _function);
    }
  };
  
  private final NodeLabelMapping<BundleDescription> pluginVersion = new NodeLabelMapping<BundleDescription>(this, BundleNode.BUNDLE_VERSION) {
    @Override
    public BaseNodeLabel<BundleDescription> createLabel(final IMappedElementDescriptor<BundleDescription> descriptor, final BundleDescription bundle) {
      BaseNodeLabel<BundleDescription> _createLabel = super.createLabel(descriptor, bundle);
      final Procedure1<BaseNodeLabel<BundleDescription>> _function = (BaseNodeLabel<BundleDescription> it) -> {
        Text _text = it.getText();
        final Procedure1<Text> _function_1 = (Text it_1) -> {
          it_1.setText(bundle.getVersion().toString());
          String _family = it_1.getFont().getFamily();
          double _size = it_1.getFont().getSize();
          double _multiply = (_size * 0.8);
          it_1.setFont(Font.font(_family, _multiply));
        };
        ObjectExtensions.<Text>operator_doubleArrow(_text, _function_1);
      };
      return ObjectExtensions.<BaseNodeLabel<BundleDescription>>operator_doubleArrow(_createLabel, _function);
    }
  };
  
  private final NodeLabelMapping<BundleDescription> pluginName = new NodeLabelMapping<BundleDescription>(this, BundleNode.BUNDLE_NAME) {
    @Override
    public BaseNodeLabel<BundleDescription> createLabel(final IMappedElementDescriptor<BundleDescription> descriptor, final BundleDescription it) {
      BaseNodeLabel<BundleDescription> _baseNodeLabel = new BaseNodeLabel<BundleDescription>(descriptor);
      final Procedure1<BaseNodeLabel<BundleDescription>> _function = (BaseNodeLabel<BundleDescription> it_1) -> {
        Text _text = it_1.getText();
        final Function1<IPluginModelBase, String> _function_1 = (IPluginModelBase it_2) -> {
          return it_2.getPluginBase().getResourceString(it_2.getPluginBase().getName());
        };
        _text.setText(((BundleDescriptor) descriptor).<String>withPlugin(_function_1));
      };
      return ObjectExtensions.<BaseNodeLabel<BundleDescription>>operator_doubleArrow(_baseNodeLabel, _function);
    }
  };
  
  private final NodeLabelMapping<BundleDescription> pluginProvider = new NodeLabelMapping<BundleDescription>(this, BundleNode.BUNDLE_PROVIDER) {
    @Override
    public BaseNodeLabel<BundleDescription> createLabel(final IMappedElementDescriptor<BundleDescription> descriptor, final BundleDescription it) {
      BaseNodeLabel<BundleDescription> _baseNodeLabel = new BaseNodeLabel<BundleDescription>(descriptor);
      final Procedure1<BaseNodeLabel<BundleDescription>> _function = (BaseNodeLabel<BundleDescription> it_1) -> {
        Text _text = it_1.getText();
        final Function1<IPluginModelBase, String> _function_1 = (IPluginModelBase it_2) -> {
          return it_2.getPluginBase().getResourceString(it_2.getPluginBase().getProviderName());
        };
        _text.setText(((BundleDescriptor) descriptor).<String>withPlugin(_function_1));
      };
      return ObjectExtensions.<BaseNodeLabel<BundleDescription>>operator_doubleArrow(_baseNodeLabel, _function);
    }
  };
  
  private final NodeLabelMapping<BundleDescription> pluginExecutionEnvironment = new NodeLabelMapping<BundleDescription>(this, BundleNode.BUNDLE_EXECUTION_ENVIRONMENT) {
    @Override
    public String getText(final BundleDescription bundle) {
      return IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(bundle.getExecutionEnvironments())), ", ");
    }
  };
  
  public NodeMapping<BundleDescription> getPluginNode() {
    return this.pluginNode;
  }
  
  private final ConnectionMapping<BundleDependency> dependencyConnection = new ConnectionMapping<BundleDependency>(this, "dependencyConnection", "Plug-in dependency") {
    @Override
    public void calls() {
      final Function1<BundleDependency, BundleDependency> _function = (BundleDependency it) -> {
        return it;
      };
      this.<BundleDependency>labelFor(BundleDiagramConfig.this.versionRange, _function);
      final Function1<BundleDependency, BundleDescription> _function_1 = (BundleDependency it) -> {
        return it.getDependency();
      };
      this.<BundleDescription>target(BundleDiagramConfig.this.pluginNode, _function_1);
    }
    
    @Override
    public XConnection createConnection(final IMappedElementDescriptor<BundleDependency> descriptor) {
      return BundleDiagramConfig.this.createPluginImportConnection(descriptor);
    }
  };
  
  public ConnectionMapping<BundleDependency> getDependencyConnection() {
    return this.dependencyConnection;
  }
  
  private final ConnectionMapping<BundleDependency> inverseDependencyConnection = new ConnectionMapping<BundleDependency>(this, "inverseDependencyConnection", "Inverse Plug-in dependency") {
    @Override
    public void calls() {
      final Function1<BundleDependency, BundleDependency> _function = (BundleDependency it) -> {
        return it;
      };
      this.<BundleDependency>labelFor(BundleDiagramConfig.this.versionRange, _function);
      final Function1<BundleDependency, BundleDescription> _function_1 = (BundleDependency it) -> {
        return it.getOwner();
      };
      this.<BundleDescription>source(BundleDiagramConfig.this.pluginNode, _function_1);
    }
    
    @Override
    public XConnection createConnection(final IMappedElementDescriptor<BundleDependency> descriptor) {
      return BundleDiagramConfig.this.createPluginImportConnection(descriptor);
    }
  };
  
  public ConnectionMapping<BundleDependency> getInverseDependencyConnection() {
    return this.inverseDependencyConnection;
  }
  
  private final ConnectionLabelMapping<BundleDependency> versionRange = new ConnectionLabelMapping<BundleDependency>(this, "versionRange") {
    @Override
    public String getText(final BundleDependency element) {
      String _xifexpression = null;
      boolean _isEmpty = element.getVersionRange().isEmpty();
      if (_isEmpty) {
        _xifexpression = "";
      } else {
        _xifexpression = element.getVersionRange().toString();
      }
      return _xifexpression;
    }
  };
  
  protected BaseConnection<BundleDependency> createPluginImportConnection(final IMappedElementDescriptor<BundleDependency> descriptor) {
    BaseConnection<BundleDependency> _baseConnection = new BaseConnection<BundleDependency>(descriptor);
    final Procedure1<BaseConnection<BundleDependency>> _function = (BaseConnection<BundleDependency> connection) -> {
      final Function1<BundleDependency, Object> _function_1 = (BundleDependency it) -> {
        Object _xblockexpression = null;
        {
          boolean _isOptional = it.isOptional();
          if (_isOptional) {
            connection.getStrokeDashArray().setAll(Double.valueOf(5.0), Double.valueOf(5.0));
          }
          boolean _isReexport = it.isReexport();
          boolean _not = (!_isReexport);
          if (_not) {
            LineArrowHead _lineArrowHead = new LineArrowHead(connection, false);
            connection.setTargetArrowHead(_lineArrowHead);
          }
          BundleDependency.Kind _kind = it.getKind();
          boolean _equals = Objects.equal(_kind, BundleDependency.Kind.FRAGMENT_HOST);
          if (_equals) {
            CircleArrowHead _circleArrowHead = new CircleArrowHead(connection, true);
            connection.setSourceArrowHead(_circleArrowHead);
          }
          _xblockexpression = null;
        }
        return _xblockexpression;
      };
      descriptor.<Object>withDomainObject(_function_1);
    };
    return ObjectExtensions.<BaseConnection<BundleDependency>>operator_doubleArrow(_baseConnection, _function);
  }
  
  @Override
  protected <ARG extends Object> void entryCalls(final ARG domainArgument, @Extension final MappingAcceptor<ARG> acceptor) {
    boolean _matched = false;
    if (domainArgument instanceof BundleDescription) {
      _matched=true;
      acceptor.add(this.pluginNode);
    }
  }
}
