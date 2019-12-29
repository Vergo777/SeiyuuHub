package moe.vergo.SeiyuuHub.dl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Seiyuu {
    private int malId;
    private String imageUrl;
    private String websiteUrl;
    private String name;
    private String givenName;
    private String familyName;
    private List<String> alternateNames;
    private int memberFavorites;
    private String about;
    private List<VoiceActingRole> voiceActingRoles;
    private List<AnimeStaffPosition> animeStaffPositions;

    public int getMalId() {
        return malId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public String getName() {
        return name;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public List<String> getAlternateNames() {
        return alternateNames;
    }

    public int getMemberFavorites() {
        return memberFavorites;
    }

    public String getAbout() {
        return about;
    }

    public List<VoiceActingRole> getVoiceActingRoles() {
        return voiceActingRoles;
    }

    public List<AnimeStaffPosition> getAnimeStaffPositions() {
        return animeStaffPositions;
    }

    public void setMalId(int malId) {
        this.malId = malId;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setAlternateNames(List<String> alternateNames) {
        this.alternateNames = alternateNames;
    }

    public void setMemberFavorites(int memberFavorites) {
        this.memberFavorites = memberFavorites;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setVoiceActingRoles(List<VoiceActingRole> voiceActingRoles) {
        this.voiceActingRoles = voiceActingRoles;
    }

    public void setAnimeStaffPositions(List<AnimeStaffPosition> animeStaffPositions) {
        this.animeStaffPositions = animeStaffPositions;
    }
}
