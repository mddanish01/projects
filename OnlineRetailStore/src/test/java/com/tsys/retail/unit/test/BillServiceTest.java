package com.tsys.retail.unit.test;

import static org.junit.Assert.assertNotNull;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.tsys.retail.entity.Bill;
import com.tsys.retail.entity.LineItem;
import com.tsys.retail.repository.BillRepository;
import com.tsys.retail.repository.LineItemRepository;
import com.tsys.retail.repository.ProductRepository;
import com.tsys.retail.service.BillService;
import com.tsys.retail.util.BillStatus;

@RunWith(MockitoJUnitRunner.class)
public class BillServiceTest {

  @InjectMocks
  BillService billService;
  @Mock
  private BillRepository billRepo;
  @Mock
  private LineItemRepository lineItemRepo;
  @Mock
  private ProductRepository productRepo;

  @Test
  public void addProductToBill() {
    List<Bill> billList = new ArrayList<>();
    Bill bill = new Bill();
    bill.setBillStatus(BillStatus.RELEASED);
    bill.setId(1l);
    bill.setNoOfItems(4);
    bill.setTotalCost(100);
    bill.setTotalTax(35);
    bill.setTotalValue(135);
    LineItem lItem = new LineItem();
    lItem.setId(1l);
    lItem.setQuantity(2);
    bill.setLineItems(new ArrayList() {
      {
        add(lItem);
      }
    });
    billList.add(bill);
    Mockito.when(billRepo.findAll()).thenReturn(billList);
    billService.getAllBills();
    assertNotNull(billService.getAllBills());
  }


}
