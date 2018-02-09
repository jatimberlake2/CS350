package Project3Else;
public class CSample
{
	public String recordNo;
	public String zip;
	public String socialMedia;
	public String AgeGroup;
	public String AvgTime;
	
	
	public CSample(String recordNo, String zip, String socialMedia, String AgeGroup, String AvgTime)
	{
		this.recordNo = recordNo;
		this.zip = zip;
		this.socialMedia = socialMedia;
		this.AgeGroup = AgeGroup;
		this.AvgTime = AvgTime;
	}
	public CSample()
	{
		this.recordNo = "";
		this.zip = "";
		this.socialMedia = "";
		this.AgeGroup = "";
		this.AvgTime = "---";
	}
	
	@Override
	public String toString()
	{
		// Formats the string so that it aligns the parts into columns under the headings by adding pad spaces to the right of each part.
		return String.format("%-21s %-22s %-21s %-21s %s", this.recordNo, this.zip, this.socialMedia, this.AgeGroup, this.AvgTime);
	}
}
