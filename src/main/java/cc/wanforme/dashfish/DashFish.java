package cc.wanforme.dashfish;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import cc.wanforme.dashfish.function.DragableWindow;
import cc.wanforme.dashfish.fxml.ImageSelectorView;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

@SpringBootApplication
public class DashFish extends AbstractJavaFxApplicationSupport {
//	private static final Logger LOG = LoggerFactory.getLogger(DashFish.class);
	
	public static void main(String[] args) {
        launch(DashFish.class, ImageSelectorView.class, args);
    }
    
	
	@Override
	public void beforeInitialView(Stage stage, ConfigurableApplicationContext ctx) {
		stage.setOnShown(e -> {
			// 绑定拖拽
	        DragableWindow.dragWindow(stage.getScene(), stage);	
		});
		
        
		stage.initStyle(StageStyle.TRANSPARENT); // stage 设置无边框透明
		stage.setResizable(false);
		stage.setAlwaysOnTop(false);
	}
	
	@Override
	public void beforeShowingSplash(Stage splashStage) {

        
	}
	
	/*
    public void myStart(Stage stage) throws NoSuchMethodException {
    	
    	String path = "G:\\Q图MessicPictures";
//    	ImgSelector pane = new ImgSelector(path);
    	ImgSelectorWrapper pane = new ImgSelectorWrapper(path);
    	pane.setPrefWidth(660);
    	pane.setPrefHeight(400);
    	
        Scene scene = new Scene(pane, pane.getPrefWidth(), pane.getPrefHeight());
        scene.fillProperty().set(Color.TRANSPARENT); // scene 设置透明，默认会是白色背景
        
        // 设置透明样式，第二种：maven， main.css 放到 src/main/resources 下即可
        scene.getStylesheets().add("css/main.css");
        
        // 绑定拖拽
        DragableWindow.dragWindow(scene, stage);
        
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT); // stage 设置无边框透明
        stage.setResizable(false);
        stage.setAlwaysOnTop(false);
//        stage.show();
    }
    */

}