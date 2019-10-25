package com.example.salur.Models;

import com.google.gson.annotations.SerializedName;

public class PantiData{

	@SerializedName("id_panti")
	private int idPanti;

	@SerializedName("email_panti")
	private String emailPanti;

	@SerializedName("no_hp")
	private String noHp;

	@SerializedName("nama_panti")
	private String namaPanti;

	@SerializedName("lokasi_panti")
	private String lokasiPanti;

	@SerializedName("nama_pengurus")
	private String namaPengurus;

	@SerializedName("foto_panti")
	private String fotoPanti;

	@SerializedName("kebutuhan_donatur")
	private Object kebutuhanDonatur;

	@SerializedName("kebutuhan_relawan")
	private Object kebutuhanRelawan;

	public void setIdPanti(int idPanti){
		this.idPanti = idPanti;
	}

	public int getIdPanti(){
		return idPanti;
	}

	public void setEmailPanti(String emailPanti){
		this.emailPanti = emailPanti;
	}

	public String getEmailPanti(){
		return emailPanti;
	}

	public void setNoHp(String noHp){
		this.noHp = noHp;
	}

	public String getNoHp(){
		return noHp;
	}

	public void setNamaPanti(String namaPanti){
		this.namaPanti = namaPanti;
	}

	public String getNamaPanti(){
		return namaPanti;
	}

	public void setLokasiPanti(String lokasiPanti){
		this.lokasiPanti = lokasiPanti;
	}

	public String getLokasiPanti(){
		return lokasiPanti;
	}

	public void setNamaPengurus(String namaPengurus){
		this.namaPengurus = namaPengurus;
	}

	public String getNamaPengurus(){
		return namaPengurus;
	}

	public void setFotoPanti(String fotoPanti){
		this.fotoPanti = fotoPanti;
	}

	public String getFotoPanti(){
		return fotoPanti;
	}

	public void setKebutuhanDonatur(Object kebutuhanDonatur){
		this.kebutuhanDonatur = kebutuhanDonatur;
	}

	public Object getKebutuhanDonatur(){
		return kebutuhanDonatur;
	}

	public void setKebutuhanRelawan(Object kebutuhanRelawan){
		this.kebutuhanRelawan = kebutuhanRelawan;
	}

	public Object getKebutuhanRelawan(){
		return kebutuhanRelawan;
	}

	@Override
 	public String toString(){
		return 
			"PantiData{" + 
			"id_panti = '" + idPanti + '\'' + 
			",email_panti = '" + emailPanti + '\'' + 
			",no_hp = '" + noHp + '\'' + 
			",nama_panti = '" + namaPanti + '\'' + 
			",lokasi_panti = '" + lokasiPanti + '\'' + 
			",nama_pengurus = '" + namaPengurus + '\'' + 
			",foto_panti = '" + fotoPanti + '\'' + 
			",kebutuhan_donatur = '" + kebutuhanDonatur + '\'' + 
			",kebutuhan_relawan = '" + kebutuhanRelawan + '\'' + 
			"}";
		}
}