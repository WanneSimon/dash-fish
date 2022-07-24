package cc.wanforme.dashfish.function;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DragableWindow {

    /** 让无边框透明背景的窗口可以拖拽
     * @param root
     * @param stage
     */
    public static void dragWindow(Scene root, Stage stage) {
    	SimpleDoubleProperty relativeX = new SimpleDoubleProperty(0);
        SimpleDoubleProperty relativeY = new SimpleDoubleProperty(0);
        // 用于优化，MouseDragged触发太快，会导致窗口抖动，触发次数减半则可以减轻这种现象
        SimpleBooleanProperty flip = new SimpleBooleanProperty(false);
        
        root.setOnMousePressed(e -> {
        	relativeX.set(e.getX());
        	relativeY.set(e.getY());
        	e.consume();
        });
        
        root.setOnMouseReleased(e -> {
        	relativeX.set(0);
        	relativeY.set(0);
        	e.consume();
        });
        
		root.setOnMouseDragged(e -> {
			flip.set(!flip.get());
			if (!flip.get()) {
				return;
			}

			double deltaX = e.getX() - relativeX.get();
			double deltaY = e.getY() - relativeY.get();

			stage.setX(stage.getX() + deltaX);
			stage.setY(stage.getY() + deltaY);
			e.consume();
		});
        
    }
    
	
}