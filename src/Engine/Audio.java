package Engine;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.sound.sampled.*;

public class Audio {

    protected AudioInputStream forestAudio, forest2Audio, winningSoundAudio, gameOverAudio, jumpingAudio, pauseAudio, mainMenuAudio, forwardAudio, backwardAudio, mountainAudio, mountain2Audio, desertAudio, desert2Audio, desert3Audio, itemBlockAudio, creditsAudio;
    protected Clip forestClip, forest2Clip, winningSoundClip, gameOverClip, jumpingClip, pauseClip, mainMenuClip, forwardClip, backwardClip, mountainClip, mountain2Clip, desertClip, desert2Clip, desert3Clip, itemBlockClip, creditsClip;
    protected ArrayList<Clip> audioList = new ArrayList<Clip>();

    public Audio() {
        audioList = loadAudio();
    }

    public ArrayList<Clip> loadAudio() {

        try {
            forestAudio = AudioSystem.getAudioInputStream(new File("Audio/Jumper.wav"));
            forestClip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, forestAudio.getFormat()));
            forestClip.open(forestAudio);

            forest2Audio = AudioSystem.getAudioInputStream(new File("Audio/Forest2.wav"));
            forest2Clip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, forest2Audio.getFormat()));
            forest2Clip.open(forest2Audio);

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

            mountainAudio = AudioSystem.getAudioInputStream(new File("Audio/MountainMusic.wav"));
            mountainClip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, mountainAudio.getFormat()));
            mountainClip.open(mountainAudio);

            mountain2Audio = AudioSystem.getAudioInputStream(new File("Audio/Mountain2Music.wav"));
            mountain2Clip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, mountain2Audio.getFormat()));
            mountain2Clip.open(mountain2Audio);

            desertAudio = AudioSystem.getAudioInputStream(new File("Audio/DesertMusic.wav"));
            desertClip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, desertAudio.getFormat()));
            desertClip.open(desertAudio);

            desert2Audio = AudioSystem.getAudioInputStream(new File("Audio/Desert2Music.wav"));
            desert2Clip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, desert2Audio.getFormat()));
            desert2Clip.open(desert2Audio);

            desert3Audio = AudioSystem.getAudioInputStream(new File("Audio/Desert3Music.wav"));
            desert3Clip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, desert3Audio.getFormat()));
            desert3Clip.open(desert3Audio);

            creditsAudio = AudioSystem.getAudioInputStream(new File("Audio/Credits.wav"));
            creditsClip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, creditsAudio.getFormat()));
            creditsClip.open(creditsAudio);

            itemBlockAudio = AudioSystem.getAudioInputStream(new File("Audio/ItemBlock.wav"));
            itemBlockClip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, itemBlockAudio.getFormat()));
            itemBlockClip.open(itemBlockAudio);

            audioList.add(forestClip); // index 0
            audioList.add(winningSoundClip); // index 1
            audioList.add(gameOverClip); // index 2
            audioList.add(jumpingClip); // index 3
            audioList.add(pauseClip); // index 4
            audioList.add(mainMenuClip); // index 5
            audioList.add(forwardClip); // index 6
            audioList.add(backwardClip); // index 7
            audioList.add(mountainClip); // index 8
            audioList.add(mountain2Clip); // index 9
            audioList.add(desertClip); // index 10
            audioList.add(desert2Clip); // index 11
            audioList.add(desert3Clip); // index 12
            audioList.add(forest2Clip); // index 13
            audioList.add(creditsClip); // index 14
            audioList.add(itemBlockClip); // index 15

            setVolume(0, -10);
            setVolume(1, -10);
            setVolume(2, -10);
            setVolume(3, -10);
            setVolume(4, -10);
            setVolume(5, -40);
            setVolume(6, -10);
            setVolume(7, -10);
            setVolume(8, -10);
            setVolume(9, -10);
            setVolume(10, -10);
            setVolume(11, -10);
            setVolume(12, -10);
            setVolume(13, -10);
            setVolume(14, -10);
            setVolume(15, -10);

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
        }
        audioList.get(index).start();

    }

    public void stopPlaying(int index) {
        audioList.get(index).stop();
    }

    public void stopPlayingAll() {
        for (int i = 0; i < audioList.size(); i++) {
            audioList.get(i).stop();
        }
    }
    public void stopPlayingMusic() {
        audioList.get(0).stop();
        audioList.get(8).stop();
        audioList.get(9).stop();
        audioList.get(10).stop();
        audioList.get(11).stop();
        audioList.get(12).stop();
        audioList.get(13).stop();
        audioList.get(14).stop();

    }

    public void resetAll() {
        for (int i = 0; i < audioList.size(); i++) {
            audioList.get(i).setFramePosition(0);
        }

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
        FloatControl forest = (FloatControl) audioList.get(0).getControl(FloatControl.Type.MASTER_GAIN);
        forest.setValue(volume);

        FloatControl forest2 = (FloatControl) audioList.get(13).getControl(FloatControl.Type.MASTER_GAIN);
        forest2.setValue(volume);

        FloatControl mountain = (FloatControl) audioList.get(8).getControl(FloatControl.Type.MASTER_GAIN);
        mountain.setValue(volume);

        FloatControl mountain2 = (FloatControl) audioList.get(9).getControl(FloatControl.Type.MASTER_GAIN);
        mountain2.setValue(volume);

        FloatControl desert = (FloatControl) audioList.get(10).getControl(FloatControl.Type.MASTER_GAIN);
        desert.setValue(volume);

        FloatControl desert2 = (FloatControl) audioList.get(11).getControl(FloatControl.Type.MASTER_GAIN);
        desert2.setValue(volume);

        FloatControl desert3 = (FloatControl) audioList.get(12).getControl(FloatControl.Type.MASTER_GAIN);
        desert3.setValue(volume);

        FloatControl credits = (FloatControl) audioList.get(14).getControl(FloatControl.Type.MASTER_GAIN);
        credits.setValue(volume);
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

        FloatControl itemBlock = (FloatControl) audioList.get(15).getControl(FloatControl.Type.MASTER_GAIN);
        itemBlock.setValue(volume);

    }

    public void setPosition(int index, int position) {
        audioList.get(index).setFramePosition(position);
    }

}
