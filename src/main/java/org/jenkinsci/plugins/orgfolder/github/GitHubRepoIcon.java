package org.jenkinsci.plugins.orgfolder.github;

import com.cloudbees.hudson.plugins.folder.FolderIcon;
import com.cloudbees.hudson.plugins.folder.FolderIconDescriptor;
import hudson.Extension;
import hudson.model.Hudson;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.Stapler;

/**
 * {@link FolderIcon} that shows the github repository icon.
 *
 * @author Kohsuke Kawaguchi
 */
public class GitHubRepoIcon extends FolderIcon {
    @DataBoundConstructor
    public GitHubRepoIcon() {
    }

    @Override
    public String getImageOf(String s) {
        return Stapler.getCurrentRequest().getContextPath()+ Hudson.RESOURCE_PATH+"/plugin/github-organization-folder/images/repo/"+s+".png";
    }

    @Override
    public String getDescription() {
        return "Repository";
    }

    @Extension
    public static class DescriptorImpl extends FolderIconDescriptor {
        @Override
        public String getDisplayName() {
            return "GitHub Repository Icon";
        }
    }
}
