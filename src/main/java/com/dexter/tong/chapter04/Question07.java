package com.dexter.tong.chapter04;

//import com.dexter.tong.common.Tuple;

import java.util.*;

public class Question07 {

    /**
     * 4.7
     * You are given a list of projects and a list of dependencies (which is a list of pairs of
     * projects, where the second project is dependent on the first project). All of a project's dependencies
     * must be built before the project is. Find a build order that will allow the projects to be built. If there
     * is no valid build order, return an error.
     */
    public LinkedList<Character> getBuildOrder(Character[] projectNames, Character[][] dependencyList){

        HashMap<Character, Project> projectsMap = new HashMap<>(projectNames.length);
        for(Character projectName : projectNames) {
            projectsMap.put(projectName, new Project(projectName));
        }

        for(Character[] dependencyPair : dependencyList) {
            Project dependency = projectsMap.get(dependencyPair[0]);
            Project dependent = projectsMap.get(dependencyPair[1]);

            dependency.dependents.add(dependent);
            dependent.dependencies++;
        }

        LinkedList<Project> projects = new LinkedList<>(projectsMap.values());
        LinkedList<Character> buildOrder = new LinkedList<>();

        while(projects.size() > 0) {
            int addCount = 0;

            Iterator<Project> iterator = projects.iterator();
            while(iterator.hasNext()) {
                Project current = iterator.next();
                if(current.dependencies < 1) {
                    addCount++;
                    for(Project dependent : current.dependents) {
                        dependent.dependencies--;
                    }
                    buildOrder.add(current.name);
                    iterator.remove();
                }
            }

            if(addCount == 0)
                throw new RuntimeException("No valid build order");
        }

        return buildOrder;
    }

    private class Project {
        private Character name;
        private ArrayList<Project> dependents;
        private int dependencies;

        private Project(Character name) {
            this.name = name;
            dependents = new ArrayList<>();
            dependencies = 0;
        }
    }
}
