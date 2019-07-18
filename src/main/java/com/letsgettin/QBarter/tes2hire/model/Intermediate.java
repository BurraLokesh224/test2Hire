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
 * @Table(name = "intermediate") public class Intermediate {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY)
 * 
 * @Column(name = "inter_id") private Long inter_id; private String inter_Board;
 * private String inter_CollegeName; private String inter_Location; private
 * String inter_Percentage; private String inter_YearOfPassing;
 * 
 * @Lob private byte[] inter_Upload;
 * 
 * @OneToOne(cascade = CascadeType.ALL)
 * 
 * @JoinColumn(name = "candidate_id") private Candidate candidate;
 * 
 * public Intermediate() {
 * 
 * }
 * 
 * public Intermediate(Long inter_id, String inter_Board, String
 * inter_CollegeName, String inter_Location, String inter_Percentage, String
 * inter_YearOfPassing, byte[] inter_Upload, Candidate candidate) { super();
 * this.inter_id = inter_id; this.inter_Board = inter_Board;
 * this.inter_CollegeName = inter_CollegeName; this.inter_Location =
 * inter_Location; this.inter_Percentage = inter_Percentage;
 * this.inter_YearOfPassing = inter_YearOfPassing; this.inter_Upload =
 * inter_Upload; this.candidate = candidate; }
 * 
 * public Long getInter_id() { return inter_id; }
 * 
 * public void setInter_id(Long inter_id) { this.inter_id = inter_id; }
 * 
 * public String getInter_Board() { return inter_Board; }
 * 
 * public void setInter_Board(String inter_Board) { this.inter_Board =
 * inter_Board; }
 * 
 * public String getInter_CollegeName() { return inter_CollegeName; }
 * 
 * public void setInter_CollegeName(String inter_CollegeName) {
 * this.inter_CollegeName = inter_CollegeName; }
 * 
 * public String getInter_Location() { return inter_Location; }
 * 
 * public void setInter_Location(String inter_Location) { this.inter_Location =
 * inter_Location; }
 * 
 * public String getInter_Percentage() { return inter_Percentage; }
 * 
 * public void setInter_Percentage(String inter_Percentage) {
 * this.inter_Percentage = inter_Percentage; }
 * 
 * public String getInter_YearOfPassing() { return inter_YearOfPassing; }
 * 
 * public void setInter_YearOfPassing(String inter_YearOfPassing) {
 * this.inter_YearOfPassing = inter_YearOfPassing; }
 * 
 * public byte[] getInter_Upload() { return inter_Upload; }
 * 
 * public void setInter_Upload(byte[] inter_Upload) { this.inter_Upload =
 * inter_Upload; }
 * 
 * public Candidate getCandidate() { return candidate; }
 * 
 * public void setCandidate(Candidate candidate) { this.candidate = candidate; }
 * 
 * }
 */