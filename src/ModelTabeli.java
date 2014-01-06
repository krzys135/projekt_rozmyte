
import javax.swing.table.AbstractTableModel;

class ModelTabeli extends AbstractTableModel {
	
	static final long serialVersionUID = 82642549L;
    
	private String[] columnNames = 
	{"Nazwa samochodu", "Pojemnoœc baga¿nika", "Spalanie", "Iloœæ drzwi", "Cena", "Satysfakcja"};
    
	private Object[][] data = new Object[0][0];
    
    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public Class<? extends Object> getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
    
    public void nowaZawartosc(Object[][] zawartosc){
    	data = new Object[zawartosc.length][6];
    	for(int i=0; i<zawartosc.length;i++){
    		data[i][0]=zawartosc[i][0];
    		data[i][1]=zawartosc[i][1];
    		data[i][2]=zawartosc[i][2];
    		data[i][3]=zawartosc[i][3];
    		data[i][4]=zawartosc[i][4];
    		data[i][5]=zawartosc[i][5];
    	}
    	fireTableDataChanged();
    }


    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }

}