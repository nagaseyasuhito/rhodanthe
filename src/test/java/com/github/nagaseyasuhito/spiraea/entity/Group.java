package com.github.nagaseyasuhito.spiraea.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.common.collect.Lists;

/**
 * グループエンティティ。
 * 
 * @author t.nagase
 */
@Entity
// groupは予約語のため、テーブル名をgroup_に変更する
@Table(name = "group_")
public class Group {
	/**
	 * ID。
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 親グループ。
	 */
	@ManyToOne
	private Group parent;

	/**
	 * グループ名。
	 */
	@Column(nullable = true, unique = true)
	private String name;

	/**
	 * 所属しているユーザーのリスト。
	 */
	@OneToMany(mappedBy = "group")
	private List<User> users = Lists.newArrayList();

	/**
	 * 子グループ。
	 */
	@OneToMany(mappedBy = "parent")
	private List<Group> children = Lists.newArrayList();

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Group getParent() {
		return this.parent;
	}

	public void setParent(Group parent) {
		this.parent = parent;
	}

	public List<Group> getChildren() {
		return this.children;
	}

	public void setChildren(List<Group> children) {
		this.children = children;
	}
}
