public class Editor{

    public Editor () {

    }

    public void newOption() {
        if ("".equals(TiaEditor.textArea.getText()))
            TiaEditor.textArea.clear();
        else
            //alert do you wanna save or nah?
            TiaEditor.textArea.setText("Save first!");
        
    }

    public void openOption() {
        TiaEditor.textArea.setText("Opened!!");
    }

    public void saveOption() {
        TiaEditor.textArea.setText("Saved!!!");
    }

    public void saveAsOption() {
        TiaEditor.textArea.setText("Saved As!!!");
    }


}
