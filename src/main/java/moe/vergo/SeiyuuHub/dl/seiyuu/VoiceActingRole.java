package moe.vergo.SeiyuuHub.dl.seiyuu;

public class VoiceActingRole {
    private String role;
    private Anime anime;
    private Character character;

    public String getRole() {
        return role;
    }

    public Anime getAnime() {
        return anime;
    }

    public Character getCharacter() {
        return character;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}
