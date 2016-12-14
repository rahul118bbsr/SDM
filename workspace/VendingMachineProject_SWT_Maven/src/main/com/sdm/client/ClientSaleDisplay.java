/**
 * 
 */
package main.com.sdm.client;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import main.com.sdm.client.listener.BuyButtonListener;
import main.com.sdm.client.listener.PropertyListener;
import main.com.sdm.client.listener.TableRowSelectionListener;
import main.com.sdm.common.enums.PaymentEnum;
import main.com.sdm.common.util.CurrencyHelper;
import main.com.sdm.server.controller.IVendingMachine;
import main.com.sdm.server.product.Product;
import main.com.sdm.server.product.ProductDescription;
import main.com.sdm.server.sale.Sale;
import main.com.sdm.server.tax.taxrules.model.TaxTypeModel;

/**
 * This class is primarily responsible for building the user interface of the product catalog page and any interaction that the user
 * performs on the UI.
 * 
 * @author Rahul Dev Mishra, Aleesha Mishra
 * @assignment Assignment 7
 * @date 18-Nov-2016 6:19:32 PM
 *
 */
public class ClientSaleDisplay implements PropertyListener {
	private IVendingMachine vendingMachine;
	private Table saleLineItemTable = null;
	private Shell shell = null;
	private Button buyButton = null;
	private List<Button> paymentModeRadioBtns = new ArrayList<Button>();
	private Group cashGroup = null;
	private Label crDbLabel = null;
	private Text cashText = null;
	private String paymentMode = null;

	public ClientSaleDisplay(Sale sale, IVendingMachine vendingMachine) {
		sale.addListener(this);
		this.vendingMachine = vendingMachine;
	}

	/**
	 * This method displays the catalog to the user for purchase.
	 */
	public void display() {
		Display display = new Display();
		shell = new Shell(display);
		shell.setLayout(new GridLayout());
		shell.setText("Only The Best Ven");

		displayProductCatalog();
		displaySaleLineItem();
		displayPaymentOptions();
		displayCashPaymentMode();
		displayCreditDebitPaymentMode();
		displayBuyButton();
		
		Monitor primary = display.getPrimaryMonitor();
	    Rectangle bounds = primary.getBounds();
	    Rectangle rect = shell.getBounds();
	    
	    int x = bounds.x + (bounds.width - rect.width) / 2;
	    int y = bounds.y + (bounds.height - rect.height) / 2;
	    
	    shell.setLocation(x, y);

		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	private void displayCashPaymentMode() {
		cashGroup = new Group(shell, SWT.NULL);
		cashGroup.setLayout(new GridLayout(2, false));
		cashGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		Label cashLabel = new Label(cashGroup, SWT.NULL);
		cashLabel.setAlignment(SWT.CENTER);
		cashLabel.setText("Amount: ");
		cashText = new Text(cashGroup, SWT.SINGLE | SWT.BORDER);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		cashText.setLayoutData(gridData);
		cashText.setFocus();
		cashGroup.setVisible(false);

		cashText.addVerifyListener(new VerifyListener() {
			@Override
			public void verifyText(VerifyEvent e) {
				String text = e.text;
				for (int i = 0; i < text.length(); i++) {
					e.doit = false;
					if (Character.isDigit(text.charAt(i))) {
						e.doit = true;
					}
					
					if (text.charAt(i) == '.') {
						e.doit = true;
					}
				}
			}
		});
	}

	private void displayCreditDebitPaymentMode() {
		crDbLabel = new Label(shell, SWT.NULL);
		crDbLabel.setAlignment(SWT.CENTER);
		crDbLabel.setText("Please click on Buy and then swipe the card on the card machine to complete the purchase.");
		crDbLabel.setVisible(false);
	}

	private void displayBuyButton() {
		buyButton = new Button(shell, SWT.PUSH);
		buyButton.setText("Buy");
		buyButton.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM, true, true));
		buyButton.setEnabled(false);
		buyButton.addSelectionListener(new BuyButtonListener(this));
	}
	
	private void displayPaymentOptions() {
		Group group = new Group(shell, SWT.NULL);
		group.setLayout(new GridLayout(2, true));
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		Label label = new Label(group, SWT.NULL);
		label.setAlignment(SWT.CENTER);
		label.setText("Payment Modes");
		new Label(group, SWT.NULL);
		Button cashRadioBtn = new Button(group, SWT.RADIO);
		cashRadioBtn.setText("Cash");
		cashRadioBtn.setEnabled(false);

		cashRadioBtn.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				buyButton.setEnabled(true);
				cashGroup.setVisible(true);
				crDbLabel.setVisible(false);
				paymentMode = PaymentEnum.CASH.getPaymentTypeStr();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		Button crDbRadioBtn = new Button(group, SWT.RADIO);
		crDbRadioBtn.setText("Credit/Debit Card");
		crDbRadioBtn.setEnabled(false);
		crDbRadioBtn.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				buyButton.setEnabled(true);
				cashGroup.setVisible(false);
				crDbLabel.setVisible(true);
				paymentMode = PaymentEnum.CARD.getPaymentTypeStr();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		paymentModeRadioBtns.add(cashRadioBtn);
		paymentModeRadioBtns.add(crDbRadioBtn);
	}

	private void displaySaleLineItem() {
		Group saleLineGroup = new Group(shell, SWT.NULL);
		saleLineGroup.setLayout(new GridLayout());
		Label label = new Label(saleLineGroup, SWT.NULL);
		label.setAlignment(SWT.CENTER);
		label.setText("Product Details.");

		saleLineItemTable = new Table(saleLineGroup, SWT.BORDER);
		saleLineItemTable.setLinesVisible(true);
		saleLineItemTable.setHeaderVisible(true);
		for (int i = 0; i < 2; i++) {
			TableColumn column = new TableColumn(saleLineItemTable, SWT.BOLD | SWT.CENTER);
			column.setWidth(500);
		}
	}

	private void displayProductCatalog() {
		Group group = new Group(shell, SWT.NULL);
		group.setLayout(new GridLayout());
		Label label = new Label(group, SWT.NULL);
		label.setAlignment(SWT.CENTER);
		label.setText("Plese select a product by clicking on the desired row.");

		Table table = new Table(group, SWT.SINGLE | SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		table.setLayoutData(data);
		String[] titles = { "Product ID", "Product Description", "Cost", "Quantity" };
		for (int i = 0; i < titles.length; i++) {
			TableColumn column = new TableColumn(table, SWT.BOLD | SWT.CENTER);
			column.setText(titles[i]);
			column.setWidth(250);
		}

		String currency = " " + CurrencyHelper.fetchCurrency();

		for (Product product : vendingMachine.fetchProductCatalog()) {
			if(product.getQuantity() <= 0) {
				continue;
			}
			ProductDescription productDescription = product.getProductDescription();
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(0, productDescription.getProductId());
			item.setText(1, productDescription.getDescription());
			item.setText(2, productDescription.getPrice().toString() + currency);
			item.setText(3, Integer.toString(product.getQuantity()));
		}

		table.addSelectionListener(new TableRowSelectionListener(this, vendingMachine));
	}

	@Override
	public void onPropertyEventBeforeSale(Sale sale) {
		saleLineItemTable.removeAll();
		String currency = " " + CurrencyHelper.fetchCurrency();
		TableItem item = new TableItem(saleLineItemTable, SWT.NONE);
		item.setText(0, sale.getProduct().getProductDescription().getDescription());
		item.setText(1, sale.getProduct().getProductDescription().getPrice().toString() + currency);

		for (TaxTypeModel taxTypeModel : sale.getTaxModel().getTaxTypeModelList()) {
			item = new TableItem(saleLineItemTable, SWT.NONE);
			item.setText(0, taxTypeModel.getTaxName());
			item.setText(1, taxTypeModel.getTaxValue().toString() + "%");
		}

		item = new TableItem(saleLineItemTable, SWT.NONE);
		item.setText(0, "TOTAL");
		item.setText(1, sale.getTaxModel().getProductPriceIncludingTax().toString() + currency);
		shell.pack();
	}

	@Override
	public void onPropertyEventAfterSale(Sale sale) {
		String currency = CurrencyHelper.fetchCurrency();
		String str = "\n*********************************************************************** \n";
		str = str + "Receipt Details: \n";
		str = str + "\t\t\tOnly the Best Ven \n" + "\t\t\tMelbourne, Florida - 32901\n";
		str = str + "\t\t\tDate: " + LocalDateTime.now() + "\n";
		System.out.println(str);
		System.out.printf( "%-50s %-10s %n", sale.getProduct().getProductDescription().getDescription(), 
				sale.getProduct().getProductDescription().getPrice() + " " + currency);
		for(TaxTypeModel taxType : sale.getTaxModel().getTaxTypeModelList()) {
			String taxName = taxType.getTaxName();
			String taxValue = taxType.getTaxValue().toString() + "%";
			System.out.printf( "%-50s %-10s %n", taxName, taxValue);
		}
		System.out.printf( "%-50s %-10s %n", "TOTAL", sale.getTaxModel().getProductPriceIncludingTax() + " " + currency);
		System.out.printf( "%-50s %-10s %n", "AMOUNT TENDERED", sale.getPayment().getReceipt().getTenderedAmount() + " " + currency);
		System.out.printf( "%-50s %-10s %n", "CHANGE DUE", sale.getPayment().getReceipt().getBalanceAmount() + " " + currency);
		System.out.println("***********************************************************************");
	}
	
	public List<Button> getPaymentModeRadioBtns() {
		return paymentModeRadioBtns;
	}
	
	public Shell getShell() {
		return shell;
	}
	
	public String getPaymentMode() {
		return paymentMode;
	}
	
	public IVendingMachine getVendingMachine() {
		return vendingMachine;
	}
	
	public Text getCashText() {
		return cashText;
	}
}
