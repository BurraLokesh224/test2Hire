/*
 * package com.letsgettin.QBarter.tes2hire.model;
 * 
 * import javax.persistence.CascadeType; import javax.persistence.Column; import
 * javax.persistence.Entity; import javax.persistence.GeneratedValue; import
 * javax.persistence.GenerationType; import javax.persistence.Id; import
 * javax.persistence.JoinColumn; import javax.persistence.Lob; import
 * javax.persistence.OneToOne; import javax.persistence.Table;
 * 
 * @Entity
 * 
 * @Table(name = "sslc") public class Sslc {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY)
 * 
 * @Column(name = "sslc_id") private Long sslc_id; private String sslc_Board;
 * private String sslc_SchoolName; private String sslc_Location; private String
 * sslc_Percentage; private String sslc_YearOfPassing;
 * 
 * @Lob private byte[] sslc_upload;
 * 
 * @OneToOne(cascade = CascadeType.ALL)
 * 
 * @JoinColumn(name = "candidate_id") private Candidate candidate;
 * 
 * public Sslc() {
 * 
 * }
 * 
 * public Sslc(Long sslc_id, String sslc_Board, String sslc_SchoolName, String
 * sslc_Location, String sslc_Percentage, String sslc_YearOfPassing, byte[]
 * sslc_upload, Candidate candidate) { super(); this.sslc_id = sslc_id;
 * this.sslc_Board = sslc_Board; this.sslc_SchoolName = sslc_SchoolName;
 * this.sslc_Location = sslc_Location; this.sslc_Percentage = sslc_Percentage;
 * this.sslc_YearOfPassing = sslc_YearOfPassing; this.sslc_upload = sslc_upload;
 * this.candidate = candidate; }
 * 
 * 
 * public Long getSslc_id() { return sslc_id; }
 * 
 * public void setSslc_id(Long sslc_id) { this.sslc_id = sslc_id; }
 * 
 * public String getSslc_Board() { return sslc_Board; }
 * 
 * public void setSslc_Board(String sslc_Board) { this.sslc_Board = sslc_Board;
 * }
 * 
 * public String getSslc_SchoolName() { return sslc_SchoolName; }
 * 
 * public void setSslc_SchoolName(String sslc_SchoolName) { this.sslc_SchoolName
 * = sslc_SchoolName; }
 * 
 * public String getSslc_Location() { return sslc_Location; }
 * 
 * public void setSslc_Location(String sslc_Location) { this.sslc_Location =
 * sslc_Location; }
 * 
 * public String getSslc_Percentage() { return sslc_Percentage; }
 * 
 * public void setSslc_Percentage(String sslc_Percentage) { this.sslc_Percentage
 * = sslc_Percentage; }
 * 
 * public String getSslc_YearOfPassing() { return sslc_YearOfPassing; }
 * 
 * public void setSslc_YearOfPassing(String sslc_YearOfPassing) {
 * this.sslc_YearOfPassing = sslc_YearOfPassing; }
 * 
 * public byte[] getSslc_upload() { return sslc_upload; }
 * 
 * public void setSslc_upload(byte[] sslc_upload) { this.sslc_upload =
 * sslc_upload; }
 * 
 * public Candidate getCandidate() { return candidate; }
 * 
 * public void setCandidate(Candidate candidate) { this.candidate = candidate; }
 * 
 * }
 */