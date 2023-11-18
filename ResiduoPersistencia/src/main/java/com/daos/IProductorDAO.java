/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.daos;

import entitys.ProductorModel;
import java.util.List;

/**
 *
 * @author xfs85
 */
public interface IProductorDAO {
    public ProductorModel create(ProductorModel productorModel);
    public List<ProductorModel> findProductorModelEntities();
    public List<ProductorModel> findProductorModelEntities(int maxResults, int firstResult);
    public ProductorModel findProductorModel(Long id);
    public int getProductorModelCount();
    
    
}
