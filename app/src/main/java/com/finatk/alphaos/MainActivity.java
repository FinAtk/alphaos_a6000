
package com.finatk.alphaos;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * ALPHA OS application shell.
 *
 * This is an interface prototype implemented with native Android views.
 * Camera operations are intentionally not connected at this stage.
 */
public class MainActivity extends Activity {

    private static final int BACKGROUND = Color.rgb(12, 12, 12);
    private static final int PANEL = Color.rgb(27, 27, 27);
    private static final int PRIMARY = Color.rgb(238, 238, 238);
    private static final int SECONDARY = Color.rgb(145, 145, 145);
    private static final int ACCENT = Color.rgb(190, 190, 190);

    private LinearLayout root;
    private LinearLayout content;
    private CameraGateway cameraGateway;

    private String currentScreen = "SHOOT";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cameraGateway = new UnconnectedCameraGateway();

        showScreen("SHOOT");
    }

    private void showScreen(String screen) {
        currentScreen = screen;

        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(BACKGROUND);
        root.setPadding(20, 14, 20, 12);

        setContentView(root);

        addHeader();
        addNavigation();

        ScrollView scroll = new ScrollView(this);
        scroll.setFillViewport(true);

        content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        content.setPadding(0, 18, 0, 20);

        scroll.addView(content);

        root.addView(
            scroll,
            new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0,
                1
            )
        );

        if ("SHOOT".equals(screen)) {
            showShootScreen();
        } else if ("PROFILES".equals(screen)) {
            showProfilesScreen();
        } else if ("LIBRARY".equals(screen)) {
            showLibraryScreen();
        } else if ("SYSTEM".equals(screen)) {
            showSystemScreen();
        }
    }

    private void addHeader() {
        LinearLayout header = new LinearLayout(this);
        header.setOrientation(LinearLayout.HORIZONTAL);
        header.setGravity(Gravity.CENTER_VERTICAL);

        TextView brand = new TextView(this);
        brand.setText("ALPHA OS");
        brand.setTextColor(PRIMARY);
        brand.setTextSize(20);
        brand.setTypeface(Typeface.DEFAULT, Typeface.BOLD);

        header.addView(
            brand,
            new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1
            )
        );

        TextView version = new TextView(this);
        version.setText("BUILD 0.1.0");
        version.setTextColor(SECONDARY);
        version.setTextSize(10);

        header.addView(version);

        root.addView(header);

        View divider = new View(this);
        divider.setBackgroundColor(Color.rgb(65, 65, 65));

        LinearLayout.LayoutParams dividerParams =
            new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                1
            );

        dividerParams.topMargin = 12;
        root.addView(divider, dividerParams);
    }

    private void addNavigation() {
        LinearLayout navigation = new LinearLayout(this);
        navigation.setOrientation(LinearLayout.HORIZONTAL);
        navigation.setGravity(Gravity.CENTER_VERTICAL);

        addNavigationButton(navigation, "SHOOT");
        addNavigationButton(navigation, "PROFILES");
        addNavigationButton(navigation, "LIBRARY");
        addNavigationButton(navigation, "SYSTEM");

        LinearLayout.LayoutParams params =
            new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                48
            );

        params.topMargin = 8;
        root.addView(navigation, params);
    }

    private void addNavigationButton(
        LinearLayout navigation,
        final String destination
    ) {
        Button button = new Button(this);

        button.setText(destination);
        button.setTextSize(10);
        button.setTextColor(
            currentScreen.equals(destination) ? PRIMARY : SECONDARY
        );
        button.setBackgroundColor(
            currentScreen.equals(destination) ? PANEL : BACKGROUND
        );

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                showScreen(destination);
            }
        });

        navigation.addView(
            button,
            new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.MATCH_PARENT,
                1
            )
        );
    }

    private void showShootScreen() {
        addSectionTitle("SHOOTING");
        addDescription("Photography workspace");

        LinearLayout preview = createPanel();
        preview.setMinimumHeight(170);
        preview.setGravity(Gravity.CENTER);
        preview.setOrientation(LinearLayout.VERTICAL);

        TextView previewTitle = new TextView(this);
        previewTitle.setText("CAMERA PREVIEW");
        previewTitle.setTextColor(PRIMARY);
        previewTitle.setTextSize(15);
        previewTitle.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        previewTitle.setGravity(Gravity.CENTER);

        preview.addView(previewTitle);

        TextView previewStatus = new TextView(this);
        previewStatus.setText("PREVIEW NOT CONNECTED");
        previewStatus.setTextColor(SECONDARY);
        previewStatus.setTextSize(10);
        previewStatus.setGravity(Gravity.CENTER);

        LinearLayout.LayoutParams statusParams =
            new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            );

        statusParams.topMargin = 10;
        preview.addView(previewStatus, statusParams);

        addPanel(preview);

        addSectionTitle("CAMERA STATUS");

        addInformationRow(
            "CONNECTION",
            "NOT TESTED"
        );

        addInformationRow(
            "HARDWARE",
            "Sony ILCE 6000"
        );

        addInformationRow(
            "FIRMWARE",
            "3.21 (owner reported)"
        );

        addInformationRow(
            "INTEGRATION",
            "NOT IMPLEMENTED"
        );

        addSectionTitle("QUICK ACCESS");

        addActionButton("SHOOTING PROFILES", "PROFILES");
        addActionButton("IMAGE LIBRARY", "LIBRARY");
    }

    private void showProfilesScreen() {
        addSectionTitle("COLOUR AND SHOOTING");
        addDescription(
            "A future home for configurable camera profiles."
        );

        addProfileCard(
            "STANDARD",
            "Neutral starting point for everyday photography.",
            "NOT CONFIGURED"
        );

        addProfileCard(
            "PORTRAIT",
            "A profile direction for natural skin tones.",
            "NOT CONFIGURED"
        );

        addProfileCard(
            "MONOCHROME",
            "A black and white shooting profile.",
            "NOT CONFIGURED"
        );

        addProfileCard(
            "LANDSCAPE",
            "A profile direction for outdoor photography.",
            "NOT CONFIGURED"
        );

        addDescription(
            "These are interface concepts only. No camera settings " +
            "are currently read or changed by ALPHA OS."
        );
    }

    private void showLibraryScreen() {
        addSectionTitle("IMAGE LIBRARY");

        addDescription(
            "A future browser for photographs stored on the camera."
        );

        LinearLayout panel = createPanel();
        panel.setMinimumHeight(150);
        panel.setGravity(Gravity.CENTER);
        panel.setOrientation(LinearLayout.VERTICAL);

        TextView title = new TextView(this);
        title.setText("NO IMAGES LOADED");
        title.setTextColor(PRIMARY);
        title.setTextSize(14);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setGravity(Gravity.CENTER);

        panel.addView(title);

        TextView description = new TextView(this);
        description.setText(
            "Memory card access has not been implemented."
        );
        description.setTextColor(SECONDARY);
        description.setTextSize(11);
        description.setGravity(Gravity.CENTER);

        LinearLayout.LayoutParams params =
            new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            );

        params.topMargin = 10;
        panel.addView(description, params);

        addPanel(panel);
    }

    private void showSystemScreen() {
        addSectionTitle("SYSTEM INFORMATION");

        addInformationRow("APPLICATION", "ALPHA OS");
        addInformationRow("VERSION", "0.1.0");
        addInformationRow("TARGET", "Sony ILCE 6000");
        addInformationRow("CAMERA FIRMWARE", "3.21 (owner reported)");
        addInformationRow("CAMERA API", "2.4 (reference documentation)");
        addInformationRow("CAMERA CONNECTION", "NOT TESTED");

        addSectionTitle("CAPABILITY STATUS");

        addInformationRow("LIVE PREVIEW", "NOT IMPLEMENTED");
        addInformationRow("AUTOFOCUS", "NOT IMPLEMENTED");
        addInformationRow("IMAGE CAPTURE", "NOT IMPLEMENTED");
        addInformationRow("CAMERA SETTINGS", "NOT IMPLEMENTED");
        addInformationRow("COLOUR PROFILES", "NOT IMPLEMENTED");
        addInformationRow("IMAGE RECOGNITION", "NOT IMPLEMENTED");

        addSectionTitle("PLATFORM");

        addDescription(cameraGateway.getConnectionDescription());

        addDescription(
            "ALPHA OS is currently an independent application shell. " +
            "The original camera firmware is not modified."
        );
    }

    private void addSectionTitle(String text) {
        TextView title = new TextView(this);
        title.setText(text);
        title.setTextColor(PRIMARY);
        title.setTextSize(13);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);

        LinearLayout.LayoutParams params =
            new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            );

        params.topMargin = 14;
        params.bottomMargin = 8;

        content.addView(title, params);
    }

    private void addDescription(String text) {
        TextView description = new TextView(this);
        description.setText(text);
        description.setTextColor(SECONDARY);
        description.setTextSize(11);

        LinearLayout.LayoutParams params =
            new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            );

        params.bottomMargin = 12;
        content.addView(description, params);
    }

    private LinearLayout createPanel() {
        LinearLayout panel = new LinearLayout(this);
        panel.setOrientation(LinearLayout.VERTICAL);
        panel.setBackgroundColor(PANEL);
        panel.setPadding(16, 14, 16, 14);
        return panel;
    }

    private void addPanel(View panel) {
        LinearLayout.LayoutParams params =
            new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            );

        params.bottomMargin = 10;
        content.addView(panel, params);
    }

    private void addInformationRow(String label, String value) {
        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setGravity(Gravity.CENTER_VERTICAL);
        row.setPadding(12, 10, 12, 10);
        row.setBackgroundColor(PANEL);

        TextView left = new TextView(this);
        left.setText(label);
        left.setTextColor(SECONDARY);
        left.setTextSize(10);

        row.addView(
            left,
            new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1
            )
        );

        TextView right = new TextView(this);
        right.setText(value);
        right.setTextColor(PRIMARY);
        right.setTextSize(10);
        right.setGravity(Gravity.RIGHT);

        row.addView(right);

        LinearLayout.LayoutParams params =
            new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            );

        params.bottomMargin = 2;
        content.addView(row, params);
    }

    private void addActionButton(
        String label,
        final String destination
    ) {
        Button button = new Button(this);
        button.setText(label);
        button.setTextColor(PRIMARY);
        button.setTextSize(11);
        button.setBackgroundColor(PANEL);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                showScreen(destination);
            }
        });

        LinearLayout.LayoutParams params =
            new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                48
            );

        params.bottomMargin = 5;
        content.addView(button, params);
    }

    private void addProfileCard(
        String name,
        String description,
        String status
    ) {
        LinearLayout panel = createPanel();

        TextView title = new TextView(this);
        title.setText(name);
        title.setTextColor(PRIMARY);
        title.setTextSize(14);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);

        panel.addView(title);

        TextView detail = new TextView(this);
        detail.setText(description);
        detail.setTextColor(SECONDARY);
        detail.setTextSize(11);

        LinearLayout.LayoutParams detailParams =
            new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            );

        detailParams.topMargin = 6;
        panel.addView(detail, detailParams);

        TextView state = new TextView(this);
        state.setText(status);
        state.setTextColor(ACCENT);
        state.setTextSize(9);

        LinearLayout.LayoutParams stateParams =
            new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            );

        stateParams.topMargin = 10;
        panel.addView(state, stateParams);

        addPanel(panel);
    }
}
