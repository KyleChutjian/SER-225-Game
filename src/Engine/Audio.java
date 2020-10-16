package Engine;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.*;





public class Audio {

    protected AudioInputStream backgroundAudio, winningSoundAudio, gameOverAudio, jumpingAudio, pauseAudio, mainMenuAudio, forwardAudio, backwardAudio;
    protected Clip backgroundClip, winningSoundClip, gameOverClip, jumpingClip, pauseClip, mainMenuClip, forwardClip, backwardClip;
    protected ArrayList<Clip> audioList = new ArrayList<Clip>();

    public Audio() {
        audioList = loadAudio();
    }

    public ArrayList<Clip> loadAudio() {

        try {
            backgroundAudio = AudioSystem.getAudioInputStream(new File("Audio/Jumper.wav"));
            backgroundClip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, backgroundAudio.getFormat()));
            backgroundClip.open(backgroundAudio);

            winningSoundAudio = AudioSystem.getAudioInputStream(new File("Audio/winningSound.wav"));
            winningSoundClip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, winningSoundAudio.getFormat()));
            winningSoundClip.open(winningSoundAudio);

            gameOverAudio = AudioSystem.getAudioInputStream(new File("Audio/gameOver.wav"));
            gameOverClip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, gameOverAudio.getFormat()));
            gameOverClip.open(gameOverAudio);

            jumpingAudio = AudioSystem.getAudioInputStream(new File("Audio/JumpingSound.wav"));
            jumpingClip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, jumpingAudio.getFormat()));
            jumpingClip.open(jumpingAudio);

            pauseAudio = AudioSystem.getAudioInputStream(new File("Audio/Pause.wav"));
            pauseClip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, pauseAudio.getFormat()));
            pauseClip.open(pauseAudio);

            mainMenuAudio = AudioSystem.getAudioInputStream(new File("Audio/MainMenu.wav"));
            mainMenuClip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, mainMenuAudio.getFormat()));
            mainMenuClip.open(mainMenuAudio);

            forwardAudio = AudioSystem.getAudioInputStream(new File("Audio/Forward.wav"));
            forwardClip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, forwardAudio.getFormat()));
            forwardClip.open(forwardAudio);

            backwardAudio = AudioSystem.getAudioInputStream(new File("Audio/Backward.wav"));
            backwardClip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, backwardAudio.getFormat()));
            backwardClip.open(backwardAudio);

            audioList.add(backgroundClip); // index 0
            audioList.add(winningSoundClip); // index 1
            audioList.add(gameOverClip); // index 2
            audioList.add(jumpingClip); // index 3
            audioList.add(pauseClip); // index 4
            audioList.add(mainMenuClip); // index 5
            audioList.add(forwardClip); // index 6
            audioList.add(backwardClip); // index 7

            setVolume(0, -10);
            setVolume(1, -10);
            setVolume(2, -10);
            setVolume(3, -10);
            setVolume(4, -10);
            setVolume(5, -10);
            setVolume(6, -10);
            setVolume(7, -10);

            return audioList;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void startPlayingLoop(int index) {
        if (audioList.get(index).getFramePosition() == audioList.get(index).getFrameLength()) {
            audioList.get(index).setFramePosition(0);
        } else {
            audioList.get(index).start();
        }
    }

    public void restartLoop(int index) {
        if (!audioList.get(index).isRunning()) {
            startPlayingOnce(index);
        }
    }

    public void startPlayingOnce(int index) {
        if (audioList.get(index).getFramePosition() == audioList.get(index).getFrameLength()) {
            audioList.get(index).setFramePosition(0);
            audioList.get(index).start();
        } else {
            audioList.get(index).start();
        }

    }

    public void stopPlaying(int index) {
        audioList.get(index).stop();
    }

    public void setVolume(int index, int volume) {
        FloatControl floatControl = (FloatControl) audioList.get(index).getControl(FloatControl.Type.MASTER_GAIN);
        floatControl.setValue(volume);
    }

    public void setPosition(int index, int position) {
        audioList.get(index).setFramePosition(position);
    }

}
