/**
 * 
 */
package main.com.sdm.server.service;

import main.com.sdm.server.dao.ITransactionsDao;
import main.com.sdm.server.dao.TransactionsDao;
import main.com.sdm.server.sale.Sale;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 23-Nov-2016 9:09:47 AM
 *
 */
public class TransactionsService implements ITransactionsService {

	@Override
	public void save(Sale sale) {
		ITransactionsDao transactionsDao = new TransactionsDao();
		transactionsDao.save(sale);
	}

}
