package de.fxdiagram.eclipse.commands;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import de.fxdiagram.eclipse.FXDiagramView;
import de.fxdiagram.eclipse.commands.ISelectionExtractor;
import de.fxdiagram.eclipse.mapping.AbstractMapping;
import de.fxdiagram.eclipse.mapping.MappingCall;
import de.fxdiagram.eclipse.mapping.XDiagramConfig;
import java.util.ArrayList;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.CompoundContributionItem;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ShowInDiagramContribution extends CompoundContributionItem {
  @Override
  protected IContributionItem[] getContributionItems() {
    ArrayList<ContributionItem> _xblockexpression = null;
    {
      IWorkbench _workbench = null;
      if (PlatformUI.class!=null) {
        _workbench=PlatformUI.getWorkbench();
      }
      IWorkbenchWindow _activeWorkbenchWindow = null;
      if (_workbench!=null) {
        _activeWorkbenchWindow=_workbench.getActiveWorkbenchWindow();
      }
      IWorkbenchPage _activePage = null;
      if (_activeWorkbenchWindow!=null) {
        _activePage=_activeWorkbenchWindow.getActivePage();
      }
      final IWorkbenchPage page = _activePage;
      IWorkbenchPart _activePart = null;
      if (page!=null) {
        _activePart=page.getActivePart();
      }
      final IWorkbenchPart activePart = _activePart;
      final ArrayList<ContributionItem> contributionItems = CollectionLiterals.<ContributionItem>newArrayList();
      final ISelectionExtractor.Acceptor acceptor = new ISelectionExtractor.Acceptor() {
        @Override
        public boolean accept(final Object selectedElement) {
          Iterable<? extends ContributionItem> _addMenuItemsForEntryCalls = ShowInDiagramContribution.this.addMenuItemsForEntryCalls(selectedElement, activePart);
          return Iterables.<ContributionItem>addAll(contributionItems, _addMenuItemsForEntryCalls);
        }
      };
      ISelectionExtractor.Registry _instance = ISelectionExtractor.Registry.getInstance();
      Iterable<ISelectionExtractor> _selectionExtractors = _instance.getSelectionExtractors();
      final Consumer<ISelectionExtractor> _function = new Consumer<ISelectionExtractor>() {
        @Override
        public void accept(final ISelectionExtractor it) {
          it.addSelectedElement(activePart, acceptor);
        }
      };
      _selectionExtractors.forEach(_function);
      _xblockexpression = contributionItems;
    }
    return ((IContributionItem[])Conversions.unwrapArray(_xblockexpression, IContributionItem.class));
  }
  
  public Iterable<? extends ContributionItem> addMenuItemsForEntryCalls(final Object selectedElement, final IWorkbenchPart activePart) {
    boolean _notEquals = (!Objects.equal(selectedElement, null));
    if (_notEquals) {
      XDiagramConfig.Registry _instance = XDiagramConfig.Registry.getInstance();
      Iterable<? extends XDiagramConfig> _configurations = _instance.getConfigurations();
      final Function1<XDiagramConfig, Iterable<? extends MappingCall<?, Object>>> _function = new Function1<XDiagramConfig, Iterable<? extends MappingCall<?, Object>>>() {
        @Override
        public Iterable<? extends MappingCall<?, Object>> apply(final XDiagramConfig it) {
          return it.<Object>getEntryCalls(selectedElement);
        }
      };
      Iterable<Iterable<? extends MappingCall<?, Object>>> _map = IterableExtensions.map(_configurations, _function);
      final Iterable<MappingCall<?, Object>> mappingCalls = Iterables.<MappingCall<?, Object>>concat(_map);
      boolean _isEmpty = IterableExtensions.isEmpty(mappingCalls);
      boolean _not = (!_isEmpty);
      if (_not) {
        final Function1<MappingCall<?, Object>, XDiagramConfig> _function_1 = new Function1<MappingCall<?, Object>, XDiagramConfig>() {
          @Override
          public XDiagramConfig apply(final MappingCall<?, Object> it) {
            AbstractMapping<?> _mapping = it.getMapping();
            return _mapping.getConfig();
          }
        };
        Iterable<XDiagramConfig> _map_1 = IterableExtensions.<MappingCall<?, Object>, XDiagramConfig>map(mappingCalls, _function_1);
        Set<XDiagramConfig> _set = IterableExtensions.<XDiagramConfig>toSet(_map_1);
        int _size = _set.size();
        final boolean hasMultipleConfigs = (_size > 1);
        final Function1<MappingCall<?, Object>, ContributionItem> _function_2 = new Function1<MappingCall<?, Object>, ContributionItem>() {
          @Override
          public ContributionItem apply(final MappingCall<?, Object> call) {
            return new ContributionItem() {
              final ContributionItem _this = this;
              @Override
              public void fill(final Menu menu, final int index) {
                MenuItem _menuItem = new MenuItem(menu, SWT.CHECK, index);
                final Procedure1<MenuItem> _function = new Procedure1<MenuItem>() {
                  @Override
                  public void apply(final MenuItem it) {
                    AbstractMapping<?> _mapping = call.getMapping();
                    String _iD = _mapping.getID();
                    it.setText(_iD);
                    if (hasMultipleConfigs) {
                      String _text = it.getText();
                      String _plus = (_text + " (");
                      AbstractMapping<?> _mapping_1 = call.getMapping();
                      XDiagramConfig _config = _mapping_1.getConfig();
                      String _iD_1 = _config.getID();
                      String _plus_1 = (_plus + _iD_1);
                      String _plus_2 = (_plus_1 + ")");
                      it.setText(_plus_2);
                    }
                    AbstractMapping<?> _mapping_2 = call.getMapping();
                    XDiagramConfig _config_1 = _mapping_2.getConfig();
                    String _iD_2 = _config_1.getID();
                    String _plus_3 = (_iD_2 + "#");
                    AbstractMapping<?> _mapping_3 = call.getMapping();
                    String _iD_3 = _mapping_3.getID();
                    String _plus_4 = (_plus_3 + _iD_3);
                    _this.setId(_plus_4);
                    it.addSelectionListener(new SelectionListener() {
                      @Override
                      public void widgetDefaultSelected(final SelectionEvent e) {
                      }
                      
                      @Override
                      public void widgetSelected(final SelectionEvent e) {
                        try {
                          IWorkbenchPartSite _site = activePart.getSite();
                          IWorkbenchPage _page = _site.getPage();
                          final IViewPart view = _page.showView("de.fxdiagram.eclipse.FXDiagramView");
                          if ((view instanceof FXDiagramView)) {
                            IEditorPart _xifexpression = null;
                            if ((activePart instanceof IEditorPart)) {
                              _xifexpression = ((IEditorPart)activePart);
                            } else {
                              _xifexpression = null;
                            }
                            final IEditorPart editor = _xifexpression;
                            ((FXDiagramView)view).<Object>revealElement(selectedElement, call, editor);
                          }
                        } catch (Throwable _e) {
                          throw Exceptions.sneakyThrow(_e);
                        }
                      }
                    });
                  }
                };
                ObjectExtensions.<MenuItem>operator_doubleArrow(_menuItem, _function);
              }
            };
          }
        };
        return IterableExtensions.<MappingCall<?, Object>, ContributionItem>map(mappingCalls, _function_2);
      }
    }
    return CollectionLiterals.<ContributionItem>emptyList();
  }
}