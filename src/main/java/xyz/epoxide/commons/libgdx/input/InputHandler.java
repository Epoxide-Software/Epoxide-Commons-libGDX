package xyz.epoxide.commons.libgdx.input;

import com.badlogic.gdx.InputAdapter;

public class InputHandler extends InputAdapter {
    @Override
    public boolean keyDown(int keycode) {
        for (KeyBind key : KeyBind.REGISTRY) {

            if (key.getKeyCode() == keycode) {

                key.onPressed();
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        for (KeyBind key : KeyBind.REGISTRY) {

            if (key.getKeyCode() == keycode) {

                key.onReleased();
                return true;
            }
        }
        return false;
    }

    public static void update(float delta) {
        for (KeyBind key : KeyBind.REGISTRY) {

            if (key.isPressed()) {

                key.onUpdate(delta);
            }
        }
    }
}
