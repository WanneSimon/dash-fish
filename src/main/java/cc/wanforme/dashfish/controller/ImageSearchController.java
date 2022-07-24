package cc.wanforme.dashfish.controller;

import org.springframework.beans.factory.annotation.Autowired;

import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;

@FXMLController
public class ImageSearchController {
	// 声明的顺序必须和 SceneBuilder 中的一直
	
	
    @FXML
    private FlowPane imgShowContainer;
    // 输入搜索框
    @FXML
    private TextField imgSearcherInput;

    @Autowired
    private ImgSelectorHandler handler;
    
    
    @FXML
	public void inputChange(KeyEvent e) {
		e.consume();
		String inputText = imgSearcherInput.getText();
		if(inputText==null || inputText.trim().equals("")) {
			return;
		}
//		System.out.println("inputText: " + inputText);
//		searchImageExecutor.search(inputText);
		
		handler.refresh(inputText, imgShowContainer);
	}
	
	
	
	
}
