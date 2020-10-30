package Engine;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
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
            setVolume(5, -40);
            setVolume(6, -10);
            setVolume(7, -10);

            File audioFile = new File("SavedData/AudioPreferences.txt");
            Scanner audioInput = null;
            audioInput = new Scanner(audioFile);
            int musicPreference = audioInput.nextInt();
            int effectPreference = audioInput.nextInt();

            if (musicPreference == 0) {
                setMusicVolume(-80);
            } else if (musicPreference == 1) {
                setMusicVolume(-30);
            } else if (musicPreference == 2) {
                setMusicVolume(-15);
            } else if (musicPreference == 3) {
                setMusicVolume(0);
            } else if (musicPreference == 4) {
                setMusicVolume(6);
            }

            if (effectPreference == 0) {
                setEffectVolume(-80);
            } else if (effectPreference == 1) {
                setEffectVolume(-30);
            } else if (effectPreference == 2) {
                setEffectVolume(-15);
            } else if (effectPreference == 3) {
                setEffectVolume(0);
            } else if (effectPreference == 4) {
                setEffectVolume(6);
            }



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

    public void setMusicVolume(int volume) {
        FloatControl menu = (FloatControl) audioList.get(5).getControl(FloatControl.Type.MASTER_GAIN);
        if (menu.getValue() != volume) {
            menu.setValue(volume);
            audioList.get(5).flush();
            audioList.get(5).setFramePosition(audioList.get(5).getFramePosition() - 45000);
        }

        FloatControl game = (FloatControl) audioList.get(0).getControl(FloatControl.Type.MASTER_GAIN);
        game.setValue(volume);
    }

    public void setEffectVolume(int volume) {
        FloatControl winning = (FloatControl) audioList.get(1).getControl(FloatControl.Type.MASTER_GAIN);
        winning.setValue(volume);

        FloatControl losing = (FloatControl) audioList.get(2).getControl(FloatControl.Type.MASTER_GAIN);
        losing.setValue(volume);

        FloatControl jumping = (FloatControl) audioList.get(3).getControl(FloatControl.Type.MASTER_GAIN);
        jumping.setValue(volume);

        FloatControl pause = (FloatControl) audioList.get(4).getControl(FloatControl.Type.MASTER_GAIN);
        pause.setValue(volume);

        FloatControl forward = (FloatControl) audioList.get(6).getControl(FloatControl.Type.MASTER_GAIN);
        forward.setValue(volume);

        FloatControl backward = (FloatControl) audioList.get(7).getControl(FloatControl.Type.MASTER_GAIN);
        backward.setValue(volume);

    }

    public void setPosition(int index, int position) {
        audioList.get(index).setFramePosition(position);
    }

}
