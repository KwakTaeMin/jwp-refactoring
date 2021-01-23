package kitchenpos.menu.dto;

import kitchenpos.menu.domain.MenuGroup;

public class MenuGroupRequest {
	private String name;

	public MenuGroupRequest() {
	}

	public String getName() {
		return name;
	}

	public MenuGroupRequest(String name) {
		this.name = name;
	}

	public MenuGroup toMenuGroup() {
		return new MenuGroup(name);
	}
}