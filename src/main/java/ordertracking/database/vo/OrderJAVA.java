package ordertracking.database.vo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.*;

@SuppressWarnings("restriction")
public class OrderJAVA {

	private final SimpleStringProperty status;
	private final SimpleStringProperty customerName;
	private final SimpleIntegerProperty idCustomerOrder;
	private final SimpleBooleanProperty isPaid;
	private final SimpleStringProperty datePlaced;

	public OrderJAVA(int idCustomerOrder, String status, String customerName,
			boolean isPaid, String datePlaced) {
		this.idCustomerOrder = new SimpleIntegerProperty(idCustomerOrder);
		this.status = new SimpleStringProperty(status);
		this.customerName = new SimpleStringProperty(customerName);
		this.isPaid = new SimpleBooleanProperty(isPaid);
		this.datePlaced = new SimpleStringProperty(datePlaced);
	}

	public SimpleStringProperty getStatus() {
		return status;
	}

	public SimpleStringProperty getCustomerName() {
		return customerName;
	}

	public SimpleIntegerProperty getIdCustomerOrder() {
		return idCustomerOrder;
	}

	public SimpleBooleanProperty getIsPaid() {
		return isPaid;
	}

	public SimpleStringProperty getDatePlaced() {
		return datePlaced;
	}

}
