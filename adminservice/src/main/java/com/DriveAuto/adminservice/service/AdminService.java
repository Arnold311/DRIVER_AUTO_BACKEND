package com.DriveAuto.adminservice.service;

import com.DriveAuto.adminservice.feign.*;
import com.DriveAuto.adminservice.model.*;
import com.DriveAuto.adminservice.repository.AdminRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {


    private AdminRepository adminRepository;


    private PasswordEncoder passwordEncoder;


    private UserServiceClient userServiceClient;


    private CourServiceClient courseServiceClient;


    private QuizServiceClient quizServiceClient;


    private QuestionServiceClient questionServiceClient;


    private NotificationServiceClient notificationServiceClient;

    public AdminService(AdminRepository adminRepository, PasswordEncoder passwordEncoder, UserServiceClient userServiceClient, CourServiceClient courseServiceClient, QuizServiceClient quizServiceClient, QuestionServiceClient questionServiceClient) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
        this.userServiceClient = userServiceClient;
        this.courseServiceClient = courseServiceClient;
        this.quizServiceClient = quizServiceClient;
        this.questionServiceClient = questionServiceClient;
    }

    public Admin saveAdmin(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminRepository.save(admin);
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    public Optional<Admin> getAdminByUsername(String username) {
        return Optional.ofNullable(adminRepository.findByUsername(username));
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
    public User registerUser(User user) {
        return userServiceClient.registerUser(user);
    }

    public List<User> getAllUsers() {
        return userServiceClient.getAllUsers();
    }

    public User getUserById(Long id) {
        return userServiceClient.getUserById(id);
    }

    public void deleteUser(Long id) {
        userServiceClient.deleteUser(id);
    }

    public Cours createCourse(Cours course) {
        return courseServiceClient.createCourse(course);
    }

    public List<Cours> getAllCourses() {
        return courseServiceClient.getAllCourses();
    }

    public Cours getCourseById(Long id) {
        return courseServiceClient.getCourseById(id);
    }

    public Cours updateCourse(Long id, Cours course) {
        return courseServiceClient.updateCourse(id, course);
    }

    public void deleteCourse(Long id) {
        courseServiceClient.deleteCourse(id);
    }

    public Quiz createQuiz(Quiz quiz) {
        return quizServiceClient.createQuiz(quiz);
    }

    public List<Quiz> getAllQuizzes() {
        return quizServiceClient.getAllQuizzes();
    }

    public Quiz getQuizById(Long id) {
        return quizServiceClient.getQuizById(id);
    }

    public Quiz updateQuiz(Long id, Quiz quiz) {
        return quizServiceClient.updateQuiz(id, quiz);
    }

    public void deleteQuiz(Long id) {
        quizServiceClient.deleteQuiz(id);
    }

    public Question createQuestion(Question question) {
        return questionServiceClient.createQuestion(question);
    }

    public List<Question> getAllQuestions() {
        return questionServiceClient.getAllQuestions();
    }

    public Question getQuestionById(Long id) {
        return questionServiceClient.getQuestionById(id);
    }

    public Question updateQuestion(Long id, Question question) {
        return questionServiceClient.updateQuestion(id, question);
    }

    public void deleteQuestion(Long id) {
        questionServiceClient.deleteQuestion(id);
    }

    public Notification createNotification(Long utilisateurId, String message) {
        return notificationServiceClient.createNotification(utilisateurId, message);
    }

    public List<Notification> getAllNotifications() {
        return notificationServiceClient.getAllNotifications();
    }

    public Notification getNotificationById(Long id) {
        return notificationServiceClient.getNotificationById(id);
    }

    public List<Notification> getNotificationsByUtilisateurId(Long utilisateurId) {
        return notificationServiceClient.getNotificationsByUtilisateurId(utilisateurId);
    }

    public void deleteNotification(Long id) {
        notificationServiceClient.deleteNotification(id);
    }
}