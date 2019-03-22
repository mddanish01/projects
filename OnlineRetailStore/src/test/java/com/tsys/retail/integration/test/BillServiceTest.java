package com.tsys.retail.integration.test;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.tsys.retail.entity.Bill;
import com.tsys.retail.model.BillUpdateInfo;
import com.tsys.retail.model.ProductInfoForBill;
import com.tsys.retail.service.BillService;
import com.tsys.retail.util.BillStatus;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BillServiceTest {

  @Autowired
  private BillService billService;

  @Test
  public void testBillUpdateAddMultipleProducts() {

    Bill o1 = billService.createBill(new Bill(0.0, 0, BillStatus.IN_PROGRESS));

    Long billId = o1.getId();
    BillUpdateInfo billupdateInfo = new BillUpdateInfo();
    List<ProductInfoForBill> productsToBeAdded = new ArrayList<ProductInfoForBill>();

    productsToBeAdded.add(new ProductInfoForBill("abc-0001", 2));
    productsToBeAdded.add(new ProductInfoForBill("abc-0002", 2));
    productsToBeAdded.add(new ProductInfoForBill("abc-0003", 2));
    productsToBeAdded.add(new ProductInfoForBill("abc-0004", 2));
    productsToBeAdded.add(new ProductInfoForBill("abc-0005", 2));
    billupdateInfo.setProductsToBeAdded(productsToBeAdded);
    billupdateInfo.setStatus(BillStatus.RELEASED);

    billService.updateBill(billupdateInfo, billId);
    Bill retrieveUpdatedBill = billService.getBillById(o1.getId());
    assertThat(retrieveUpdatedBill.getNoOfItems()).isEqualTo(5);
    assertThat(retrieveUpdatedBill.getTotalValue())
        .isEqualTo(20 * 2 * 1.1 + 30 * 2 * 1.2 + 40 * 2 * 1 + 50 * 2 * 1.1 + 60 * 2 * 1.2);
  }



}
