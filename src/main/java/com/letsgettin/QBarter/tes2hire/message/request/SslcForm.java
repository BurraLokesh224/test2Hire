/*
 * package com.letsgettin.QBarter.tes2hire.message.request;
 * 
 * import javax.persistence.CascadeType; import javax.persistence.JoinColumn;
 * import javax.persistence.Lob; import javax.persistence.OneToOne;
 * 
 * import com.letsgettin.QBarter.tes2hire.model.Candidate;
 * 
 * public class SslcForm { private String sslc_Board; private String
 * sslc_SchoolName; private String sslc_Location; private String
 * sslc_Percentage; private String sslc_YearOfPassing;
 * 
 * @Lob private byte[] sslc_upload;
 * 
 * @OneToOne(cascade = CascadeType.ALL)
 * 
 * @JoinColumn(name = "candidate_id") private Candidate candidate;
 * 
 * public String getSslc_Board() { return sslc_Board; }
 * 
 * public String getSslc_SchoolName() { return sslc_SchoolName; }
 * 
 * public String getSslc_Location() { return sslc_Location; }
 * 
 * public String getSslc_Percentage() { return sslc_Percentage; }
 * 
 * public String getSslc_YearOfPassing() { return sslc_YearOfPassing; }
 * 
 * public byte[] getSslc_upload() { return sslc_upload; }
 * 
 * public Candidate getCandidate() { return candidate; }
 * 
 * }
 */