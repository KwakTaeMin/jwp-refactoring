package kitchenpos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MenuProduct {
    @Id
    @Column(name = "seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private long menuId;

    @JoinColumn(name = "productId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @Column
    private Quantity quantity;

    protected MenuProduct() {
    }

    public MenuProduct(Product product, Quantity quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public MenuProduct(long menuId, Product product, Quantity quantity) {
        this.menuId = menuId;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public long getQuantity() {
        return quantity.longValue();
    }

    public Money getAmount() {
        return quantity.of(product.getPrice());
    }

    public static MenuProduct of(long menuId, Product product, Quantity quantity) {
        return new MenuProduct(menuId, product, quantity);
    }
}