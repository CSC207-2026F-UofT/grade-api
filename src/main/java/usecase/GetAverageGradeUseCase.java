package usecase;

import api.GradeDataBase;
import entity.Grade;
import entity.Team;

/**
 * GetAverageGradeUseCase class.
 */
public final class GetAverageGradeUseCase {
    private final GradeDataBase gradeDataBase;

    public GetAverageGradeUseCase(GradeDataBase gradeDataBase) {
        this.gradeDataBase = gradeDataBase;
    }

    /**
     * Get the average grade for a course across your team.
     * @param course The course.
     * @return The average grade.
     */
    public float getAverageGrade(String course) {
        float sum = 0;
        int count = 0;
        // TODO Task 3b: Go to the MongoGradeDataBase class and implement getMyTeam.
        final Team team = gradeDataBase.getMyTeam(); // Call the API to get the usernames of all team members
        // Call the API to get all the grades for the course for all your team members
        // TODO Task 3a: Complete the logic of calculating the average course grade for
        //              your team members. Hint: what methods are in the GradeDataBase interface?
        String[] teamMembers = team.getMembers();
        for (int i = 0; i < teamMembers.length; i++) {
            sum += gradeDataBase.getGrade(teamMembers[i], course).getGrade();
        }
        count = teamMembers.length;
        if (count == 0) {
            return 0;
        }
        return sum / count;
    }
}
