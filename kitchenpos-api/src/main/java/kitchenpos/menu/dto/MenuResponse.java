package kitchenpos.menu.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import kitchenpos.menu.domain.Menu;

public class MenuResponse {
	private Long id;
	private String name;
	private BigDecimal price;
	private Long menuGroupId;
	private List<MenuProductResponse> menuProducts;

	protected MenuResponse() {
	}

	public MenuResponse(Long id, String name, BigDecimal price, Long menuGroupId,
		List<MenuProductResponse> menuProducts) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.menuGroupId = menuGroupId;
		this.menuProducts = menuProducts;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Long getMenuGroupId() {
		return menuGroupId;
	}

	public List<MenuProductResponse> getMenuProducts() {
		return menuProducts;
	}

	public static MenuResponse of(Menu menu) {
		return new MenuResponse(menu.getId()
			, menu.getName()
			, menu.getPrice()
			, menu.getMenuGroupId()
			, MenuProductResponse.ofList(menu.getMenuProducts())
		);
	}

	public static List<MenuResponse> ofList(List<Menu> menus) {
		return menus.stream()
			.map(MenuResponse::of)
			.collect(Collectors.toList());
	}
}