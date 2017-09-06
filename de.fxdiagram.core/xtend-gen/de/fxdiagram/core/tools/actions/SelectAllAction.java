package de.fxdiagram.core.tools.actions;

import com.google.common.base.Objects;
import de.fxdiagram.core.XConnectionLabel;
import de.fxdiagram.core.XRoot;
import de.fxdiagram.core.XShape;
import de.fxdiagram.core.tools.actions.DiagramAction;
import eu.hansolo.enzo.radialmenu.SymbolType;
import java.util.function.Consumer;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class SelectAllAction implements DiagramAction {
  @Override
  public boolean matches(final KeyEvent it) {
    return (it.isShortcutDown() && Objects.equal(it.getCode(), KeyCode.A));
  }
  
  @Override
  public SymbolType getSymbol() {
    return SymbolType.SELECTION1;
  }
  
  @Override
  public String getTooltip() {
    return "Select all";
  }
  
  @Override
  public void perform(final XRoot root) {
    final Function1<XShape, Boolean> _function = (XShape it) -> {
      return Boolean.valueOf((!(it instanceof XConnectionLabel)));
    };
    final Consumer<XShape> _function_1 = (XShape it) -> {
      boolean _isSelectable = it.isSelectable();
      if (_isSelectable) {
        it.setSelected(true);
      }
    };
    IterableExtensions.<XShape>filter(root.getDiagram().getAllShapes(), _function).forEach(_function_1);
  }
}
