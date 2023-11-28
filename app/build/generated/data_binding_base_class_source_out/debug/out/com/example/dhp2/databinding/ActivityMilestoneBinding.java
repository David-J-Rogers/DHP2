// Generated by view binder compiler. Do not edit!
package com.example.dhp2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.dhp2.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMilestoneBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button assessButton;

  @NonNull
  public final Button doneButton;

  @NonNull
  public final Button exercise1Button;

  @NonNull
  public final Button exercise2Button;

  @NonNull
  public final Button exercise3Button;

  @NonNull
  public final ConstraintLayout milestoneLayout;

  @NonNull
  public final TextView milestoneStatusTextView;

  private ActivityMilestoneBinding(@NonNull ConstraintLayout rootView, @NonNull Button assessButton,
      @NonNull Button doneButton, @NonNull Button exercise1Button, @NonNull Button exercise2Button,
      @NonNull Button exercise3Button, @NonNull ConstraintLayout milestoneLayout,
      @NonNull TextView milestoneStatusTextView) {
    this.rootView = rootView;
    this.assessButton = assessButton;
    this.doneButton = doneButton;
    this.exercise1Button = exercise1Button;
    this.exercise2Button = exercise2Button;
    this.exercise3Button = exercise3Button;
    this.milestoneLayout = milestoneLayout;
    this.milestoneStatusTextView = milestoneStatusTextView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMilestoneBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMilestoneBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_milestone, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMilestoneBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.assessButton;
      Button assessButton = ViewBindings.findChildViewById(rootView, id);
      if (assessButton == null) {
        break missingId;
      }

      id = R.id.doneButton;
      Button doneButton = ViewBindings.findChildViewById(rootView, id);
      if (doneButton == null) {
        break missingId;
      }

      id = R.id.exercise1Button;
      Button exercise1Button = ViewBindings.findChildViewById(rootView, id);
      if (exercise1Button == null) {
        break missingId;
      }

      id = R.id.exercise2Button;
      Button exercise2Button = ViewBindings.findChildViewById(rootView, id);
      if (exercise2Button == null) {
        break missingId;
      }

      id = R.id.exercise3Button;
      Button exercise3Button = ViewBindings.findChildViewById(rootView, id);
      if (exercise3Button == null) {
        break missingId;
      }

      ConstraintLayout milestoneLayout = (ConstraintLayout) rootView;

      id = R.id.milestoneStatusTextView;
      TextView milestoneStatusTextView = ViewBindings.findChildViewById(rootView, id);
      if (milestoneStatusTextView == null) {
        break missingId;
      }

      return new ActivityMilestoneBinding((ConstraintLayout) rootView, assessButton, doneButton,
          exercise1Button, exercise2Button, exercise3Button, milestoneLayout,
          milestoneStatusTextView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}