package com.school.msreservation.application.portIn;

import com.school.msreservation.application.portOut.CoursePortOut;
import com.school.msreservation.application.portOut.ReservationPortOut;
import com.school.msreservation.application.portOut.UserPortOut;
import com.school.msreservation.domain.Course;
import com.school.msreservation.domain.Reservation;
import com.school.msreservation.domain.User;
import com.school.msreservation.domain.enuns.UserEnum;
import com.school.msreservation.infrastructure.adapter.adapterOut.QuantityCourseMatriculationAdapterOut;
import com.school.msreservation.infrastructure.adapter.adapterOut.RegisteredStudentAdapterOut;
import com.school.msreservation.infrastructure.dto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReservationPortInImplTest {

    @InjectMocks
    ReservationPortInImpl reservationPortIn;

    @Mock
    ReservationPortOut reservationPortOut;
    @Mock
    ModelMapper modelMapper;
    @Mock
    UserPortOut userPortOut;
    @Mock
    CoursePortOut coursePortOut;
    @Mock
    QuantityCourseMatriculationAdapterOut quantityCourseMatriculationAdapterOut;
    @Mock
    RegisteredStudentAdapterOut registeredStudentAdapterOut;

    @Captor
    private ArgumentCaptor<Reservation> reservationCaptor;

    CourseResponseDto courseResponseDto;
    Course course;

    UserResponseDto studentDto;
    User student;

    UserResponseDto teacherDto;
    User teacher;

    ReservationRequestDto reservationRequestDto;
    Reservation reservation;

    QuantityCourseMatriculationResponseDto quantityCourseDto;
    RegisteredStudentResponseDto registeredStudentResponseDto;

    @BeforeEach
    void setUp(){
        reservationPortIn = new ReservationPortInImpl(reservationPortOut, modelMapper, userPortOut, coursePortOut, quantityCourseMatriculationAdapterOut, registeredStudentAdapterOut);
       courseResponseDto = CourseResponseDto.builder()
               .id(UUID.randomUUID())
               .name("Curso em java")
               .description("Curso focado em java")
               .capacity(5).build();
       course = new Course(courseResponseDto.getId()
                , courseResponseDto.getName()
                , courseResponseDto.getDescription()
                , courseResponseDto.getCapacity());

       studentDto = UserResponseDto.builder()
               .id(UUID.randomUUID())
               .name("Guilherme")
               .type(UserEnum.ALUNO).build();

       student = new User(studentDto.getId()
               , studentDto.getName()
               , studentDto.getType());

       teacherDto = UserResponseDto.builder()
               .id(UUID.randomUUID())
               .name("Gustavo")
               .type(UserEnum.PROFESSOR).build();
       teacher = new User(teacherDto.getId()
               , teacherDto.getName()
               , teacherDto.getType());
       reservationRequestDto = ReservationRequestDto.builder()
               .courseId(course.getId())
               .studentId(student.getId())
               .teacherId(teacher.getId()).build();
       reservation = new Reservation(course.getId()
                    ,course.getName()
                    , student.getId()
                    ,student.getName()
                    ,teacher.getId()
                    ,teacher.getName());

        quantityCourseDto = QuantityCourseMatriculationResponseDto.builder()
                .quantityCourse(2L).build();
        registeredStudentResponseDto = RegisteredStudentResponseDto.builder()
                .thereIsStudent(false).build();

    }

    @Test
    void createReservationTest() {
        when(coursePortOut.listCourseId(reservationRequestDto.getCourseId())).thenReturn(courseResponseDto);
        when(modelMapper.map(courseResponseDto, Course.class)).thenReturn(course);
        when(userPortOut.listUserId(reservationRequestDto.getStudentId())).thenReturn(studentDto);
        when(modelMapper.map(studentDto, User.class)).thenReturn(student);
        when(userPortOut.listUserId(reservationRequestDto.getTeacherId())).thenReturn(teacherDto);
        when(modelMapper.map(teacherDto, User.class)).thenReturn(teacher);
        when(quantityCourseMatriculationAdapterOut.quantityCourse(course.getId())).thenReturn(quantityCourseDto);
        when(registeredStudentAdapterOut.registeredStudent(student.getId(), course.getId())).thenReturn(registeredStudentResponseDto);
        doNothing().when(reservationPortOut).createReservation(any());
        reservationPortIn.createReservation(reservationRequestDto);
        verify(reservationPortOut, times(1)).createReservation(any());



    }
}