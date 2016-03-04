package org.jenkinsci.plugins.orgfolder.github;

import hudson.Extension;
import hudson.model.Item;
import hudson.views.ListViewColumn;
import hudson.views.ListViewColumnDescriptor;
import org.jenkinsci.plugins.workflow.multibranch.WorkflowMultiBranchProject;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 * {@link ListViewColumn} that shows the description text of repository.
 *
 * @author Kohsuke Kawaguchi
 */
public class RepositoryDescriptionColumn extends ListViewColumn {
    @DataBoundConstructor
    public RepositoryDescriptionColumn() {
    }

    public GitHubRepoProperty getPropertyOf(Item item) {
        if (item instanceof WorkflowMultiBranchProject) {
            WorkflowMultiBranchProject job = (WorkflowMultiBranchProject) item;
            return job.getProperties().get(GitHubRepoProperty.class);
        }
        return null;
    }

    @Extension
    public static class DescriptorImpl extends ListViewColumnDescriptor {
        @Override
        public String getDisplayName() {
            return "GitHub Repository Description";
        }

        @Override
        public boolean shownByDefault() {
            return false;
        }
    }
}
