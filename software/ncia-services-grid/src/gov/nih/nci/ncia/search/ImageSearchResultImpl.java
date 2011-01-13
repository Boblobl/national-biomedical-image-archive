package gov.nih.nci.ncia.search;

/**
 * Represents a DICOM image (retrieved through drill down).
 *
 * <P><b>WARNING!</b> This object is serialized so if you change it, you risk
 * breaking remote search and the grid interface
 *
 * <p>Note: this class has a natural ordering that is inconsistent with equals.
 */
public class ImageSearchResultImpl implements ImageSearchResult  {

	public ImageSearchResultImpl() {

	}

    /**
     * @return Returns the imagePkId.
     */
    public Integer getId() {
        return imagePkId;
    }


    /**
     * @param imagePkId The imagePkId to set.
     */
    public void setId(Integer imagePkId) {
        this.imagePkId = imagePkId;
    }


    /**
     * Sort this by the instance number within the series.
     *
     * <p>Instance numbers aren't mandatory and can be null.  A null
     * instance number will be push the image to the front.
     */
    public int compareTo(ImageSearchResult o) {
        Integer instanceNumber = this.getInstanceNumber();
        Integer otherInstanceNumber = o.getInstanceNumber();

        if (instanceNumber == null) {
            return -1;
        }

        if (otherInstanceNumber == null) {
            return 1;
        }

        return instanceNumber.compareTo(otherInstanceNumber);
    }


    /**
     * {@inheritDoc}
     */
    public Integer getSeriesId() {
        return seriesPkId;
    }


    /**
     * Set the series (pk) id for the series this image is in
     */
    public void setSeriesId(Integer seriesPkId) {
        this.seriesPkId = seriesPkId;
    }


    /**
     * {@inheritDoc}
     */
    public Integer getInstanceNumber() {
        return instanceNumber;
    }


    /**
     * Setter for instance number
     *
     * @param instanceNumber
     */
    public void setInstanceNumber(Integer instanceNumber) {
        this.instanceNumber = instanceNumber;
    }


    /**
     * {@inheritDoc}
     */
    public String getSeriesInstanceUid() {
    	return  this.seriesInstanceUid;
    }


    /**
     * Set the DICOM series instance UID for the series this image is in
     */
    public void setSeriesInstanceUid(String seriesInstanceUid) {
        this.seriesInstanceUid = seriesInstanceUid;
    }


    /**
     * {@inheritDoc}
     */
    public String getSopInstanceUid() {
    	return this.sopInstanceUid;
    }

    /**
     * Set the DICOM SOP instance UID
     */
    public void setSopInstanceUid(String sopInstanceUid) {
        this.sopInstanceUid = sopInstanceUid;
    }


    /**
     * {@inheritDoc}
     */
	public Long getSize() {
		return size;
	}

	/**
	 * Set the size of the image file in bytes.
	 * @param size
	 */
	public void setSize(Long size) {
		this.size = size;
	}


    /**
     * {@inheritDoc}
     */
	public NBIANode associatedLocation() {
		return location;
	}


    /**
     * {@inheritDoc}
     */
	public void associateLocation(NBIANode location) {
		this.location = location;
	}

    /**
     * {@inheritDoc}
     */
    public String getThumbnailURL() {
    	return thumbnailURL;
    }

	/**
     * Set the URL to retrieve the thumbnail for this image result.
     */
	public void setThumbnailURL(String thumbnailURL) {
		this.thumbnailURL = thumbnailURL;
	}

	public Integer getFrameNum() {
		return frameNum;
	}

	public void setFrameNum(Integer frameSize) {
		this.frameNum = frameSize;
	}




    ///////////////////////////////////////////////PRIVATE///////////////////////////////////

    private Integer imagePkId;
    private Integer seriesPkId;
    private Integer instanceNumber;
    private String sopInstanceUid;
    private String seriesInstanceUid;
    private Long size;
    private NBIANode location;
    private String thumbnailURL;
    private Integer frameNum;
}