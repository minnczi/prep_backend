package com.lgcns.tct_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_MZ_LIST_RESTAURANT_REL")
public class MzListRestaurantRel {

  @Id
  @Column(name = "RESTAURANT_LIST_REL_ID")
  private String restaurantListRelId;

  @Column(name = "RESTAURANT_ID")
  private String restaurantId;

  @Column(name = "LIST_ID")
  private String listId;
  
}