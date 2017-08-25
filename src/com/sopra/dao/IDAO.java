package com.sopra.dao;

import java.util.List;


public interface IDAO<T>
{
	public List<T> findAll();
	public T find(int id);
	public T save(T obj);
	public void delete(T obj);
}