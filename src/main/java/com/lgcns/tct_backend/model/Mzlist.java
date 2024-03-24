package com.lgcns.tct_backend.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "tb_mzlist")
public class Mzlist {
  @Id
  @Column(name = "mzlist_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long mzlistId;

  @Column(name = "user_id")
  private Long userId;

  @Column(name = "mzlist_name")
  private String mzlistName;

  @Column(name = "mzlist_description")
  private String mzlistDescription;

  @Column(name = "mzlist_icon")
  private String mzlistIcon;

  public void updateMzlist(String mzlistName, String mzlistDescription, String mzlistIcon) {
    this.mzlistName = mzlistName;
    this.mzlistDescription = mzlistDescription;
    this.mzlistIcon = mzlistIcon;
  }
}
