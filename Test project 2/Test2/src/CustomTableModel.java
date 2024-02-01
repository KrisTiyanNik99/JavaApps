import javax.swing.table.DefaultTableModel;

public class CustomTableModel extends DefaultTableModel {
    //pravim chislo koeto da e ravno na -1 nachalnata mu stepen, za da moje da table kletkite da sa noneditable
    int num = -1;
    @Override
    public boolean isCellEditable(int row, int column) {
        //slagame proverki s koito da proverqvame i pravim kletkite editable i noneditable v zavisimost dali suvpadat
        if (row == num){
            return true;
        }else if (column == 2){
            return true;
        }else {
            return false;
        }
    }

    public void startEdit(int num){
        //suzdavame metod koito poluchava ot otvun nomera na reda koito posle shte iskame da e editable
        this.num = num;
        //pravim nasheto chislo da e ravno na reda
    }
}
