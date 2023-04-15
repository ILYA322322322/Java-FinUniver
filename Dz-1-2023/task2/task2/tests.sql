PGDMP     6                    {            tests    15.0    15.0 F    P           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            Q           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            R           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            S           1262    65992    tests    DATABASE     y   CREATE DATABASE tests WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Russian_Russia.1251';
    DROP DATABASE tests;
                postgres    false            �            1259    65993    group    TABLE     �   CREATE TABLE public."group" (
    row_id integer NOT NULL,
    name character varying(50) NOT NULL,
    year integer NOT NULL,
    semester integer
);
    DROP TABLE public."group";
       public         heap    postgres    false            �            1259    65996    GROUP_row_id_seq    SEQUENCE     �   CREATE SEQUENCE public."GROUP_row_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public."GROUP_row_id_seq";
       public          postgres    false    214            T           0    0    GROUP_row_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public."GROUP_row_id_seq" OWNED BY public."group".row_id;
          public          postgres    false    215            �            1259    65997    answer    TABLE     �   CREATE TABLE public.answer (
    row_id integer NOT NULL,
    question_id integer NOT NULL,
    text text NOT NULL,
    correct boolean NOT NULL
);
    DROP TABLE public.answer;
       public         heap    postgres    false            �            1259    66002    answer_row_id_seq    SEQUENCE     �   CREATE SEQUENCE public.answer_row_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.answer_row_id_seq;
       public          postgres    false    216            U           0    0    answer_row_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.answer_row_id_seq OWNED BY public.answer.row_id;
          public          postgres    false    217            �            1259    66003    question    TABLE     �   CREATE TABLE public.question (
    row_id integer NOT NULL,
    text text NOT NULL,
    score integer NOT NULL,
    active boolean NOT NULL
);
    DROP TABLE public.question;
       public         heap    postgres    false            �            1259    66008    question_row_id_seq    SEQUENCE     �   CREATE SEQUENCE public.question_row_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.question_row_id_seq;
       public          postgres    false    218            V           0    0    question_row_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.question_row_id_seq OWNED BY public.question.row_id;
          public          postgres    false    219            �            1259    66009    role    TABLE     c   CREATE TABLE public.role (
    row_id integer NOT NULL,
    name character varying(50) NOT NULL
);
    DROP TABLE public.role;
       public         heap    postgres    false            �            1259    66012    role_row_id_seq    SEQUENCE     �   CREATE SEQUENCE public.role_row_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.role_row_id_seq;
       public          postgres    false    220            W           0    0    role_row_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.role_row_id_seq OWNED BY public.role.row_id;
          public          postgres    false    221            �            1259    66013    schedule    TABLE     B  CREATE TABLE public.schedule (
    row_id integer NOT NULL,
    test_id integer NOT NULL,
    group_id integer NOT NULL,
    duration integer NOT NULL,
    start_dt date NOT NULL,
    start_time time without time zone NOT NULL,
    end_dt date,
    end_time time without time zone NOT NULL,
    active boolean NOT NULL
);
    DROP TABLE public.schedule;
       public         heap    postgres    false            �            1259    66016    schedule_row_id_seq    SEQUENCE     �   CREATE SEQUENCE public.schedule_row_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.schedule_row_id_seq;
       public          postgres    false    222            X           0    0    schedule_row_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.schedule_row_id_seq OWNED BY public.schedule.row_id;
          public          postgres    false    223            �            1259    66017    student_answer    TABLE     �   CREATE TABLE public.student_answer (
    row_id integer NOT NULL,
    test_id integer NOT NULL,
    user_id integer NOT NULL,
    answer_id integer NOT NULL
);
 "   DROP TABLE public.student_answer;
       public         heap    postgres    false            �            1259    66020    student_answer_row_id_seq    SEQUENCE     �   CREATE SEQUENCE public.student_answer_row_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.student_answer_row_id_seq;
       public          postgres    false    224            Y           0    0    student_answer_row_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.student_answer_row_id_seq OWNED BY public.student_answer.row_id;
          public          postgres    false    225            �            1259    66021    subject    TABLE     f   CREATE TABLE public.subject (
    row_id integer NOT NULL,
    name character varying(50) NOT NULL
);
    DROP TABLE public.subject;
       public         heap    postgres    false            �            1259    66024    subject_row_id_seq    SEQUENCE     �   CREATE SEQUENCE public.subject_row_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.subject_row_id_seq;
       public          postgres    false    226            Z           0    0    subject_row_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.subject_row_id_seq OWNED BY public.subject.row_id;
          public          postgres    false    227            �            1259    66025    test    TABLE     z   CREATE TABLE public.test (
    row_id integer NOT NULL,
    test_id integer NOT NULL,
    question_id integer NOT NULL
);
    DROP TABLE public.test;
       public         heap    postgres    false            �            1259    66028 	   test_list    TABLE     �   CREATE TABLE public.test_list (
    row_id integer NOT NULL,
    name character varying(50) NOT NULL,
    subject_id integer,
    teacher_id integer
);
    DROP TABLE public.test_list;
       public         heap    postgres    false            �            1259    66031    test_list_row_id_seq    SEQUENCE     �   CREATE SEQUENCE public.test_list_row_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.test_list_row_id_seq;
       public          postgres    false    229            [           0    0    test_list_row_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.test_list_row_id_seq OWNED BY public.test_list.row_id;
          public          postgres    false    230            �            1259    66032    test_row_id_seq    SEQUENCE     �   CREATE SEQUENCE public.test_row_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.test_row_id_seq;
       public          postgres    false    228            \           0    0    test_row_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.test_row_id_seq OWNED BY public.test.row_id;
          public          postgres    false    231            �            1259    66033    user    TABLE     ?  CREATE TABLE public."user" (
    row_id integer NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    middle_name character varying(50),
    login character varying(50),
    password_hash character varying(256),
    group_id integer,
    role_id integer NOT NULL
);
    DROP TABLE public."user";
       public         heap    postgres    false            �            1259    66036    users_row_id_seq    SEQUENCE     �   CREATE SEQUENCE public.users_row_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.users_row_id_seq;
       public          postgres    false    232            ]           0    0    users_row_id_seq    SEQUENCE OWNED BY     F   ALTER SEQUENCE public.users_row_id_seq OWNED BY public."user".row_id;
          public          postgres    false    233            �           2604    66037    answer row_id    DEFAULT     n   ALTER TABLE ONLY public.answer ALTER COLUMN row_id SET DEFAULT nextval('public.answer_row_id_seq'::regclass);
 <   ALTER TABLE public.answer ALTER COLUMN row_id DROP DEFAULT;
       public          postgres    false    217    216            �           2604    66038    group row_id    DEFAULT     p   ALTER TABLE ONLY public."group" ALTER COLUMN row_id SET DEFAULT nextval('public."GROUP_row_id_seq"'::regclass);
 =   ALTER TABLE public."group" ALTER COLUMN row_id DROP DEFAULT;
       public          postgres    false    215    214            �           2604    66039    question row_id    DEFAULT     r   ALTER TABLE ONLY public.question ALTER COLUMN row_id SET DEFAULT nextval('public.question_row_id_seq'::regclass);
 >   ALTER TABLE public.question ALTER COLUMN row_id DROP DEFAULT;
       public          postgres    false    219    218            �           2604    66040    role row_id    DEFAULT     j   ALTER TABLE ONLY public.role ALTER COLUMN row_id SET DEFAULT nextval('public.role_row_id_seq'::regclass);
 :   ALTER TABLE public.role ALTER COLUMN row_id DROP DEFAULT;
       public          postgres    false    221    220            �           2604    66041    schedule row_id    DEFAULT     r   ALTER TABLE ONLY public.schedule ALTER COLUMN row_id SET DEFAULT nextval('public.schedule_row_id_seq'::regclass);
 >   ALTER TABLE public.schedule ALTER COLUMN row_id DROP DEFAULT;
       public          postgres    false    223    222            �           2604    66042    student_answer row_id    DEFAULT     ~   ALTER TABLE ONLY public.student_answer ALTER COLUMN row_id SET DEFAULT nextval('public.student_answer_row_id_seq'::regclass);
 D   ALTER TABLE public.student_answer ALTER COLUMN row_id DROP DEFAULT;
       public          postgres    false    225    224            �           2604    66043    subject row_id    DEFAULT     p   ALTER TABLE ONLY public.subject ALTER COLUMN row_id SET DEFAULT nextval('public.subject_row_id_seq'::regclass);
 =   ALTER TABLE public.subject ALTER COLUMN row_id DROP DEFAULT;
       public          postgres    false    227    226            �           2604    66044    test row_id    DEFAULT     j   ALTER TABLE ONLY public.test ALTER COLUMN row_id SET DEFAULT nextval('public.test_row_id_seq'::regclass);
 :   ALTER TABLE public.test ALTER COLUMN row_id DROP DEFAULT;
       public          postgres    false    231    228            �           2604    66045    test_list row_id    DEFAULT     t   ALTER TABLE ONLY public.test_list ALTER COLUMN row_id SET DEFAULT nextval('public.test_list_row_id_seq'::regclass);
 ?   ALTER TABLE public.test_list ALTER COLUMN row_id DROP DEFAULT;
       public          postgres    false    230    229            �           2604    66046    user row_id    DEFAULT     m   ALTER TABLE ONLY public."user" ALTER COLUMN row_id SET DEFAULT nextval('public.users_row_id_seq'::regclass);
 <   ALTER TABLE public."user" ALTER COLUMN row_id DROP DEFAULT;
       public          postgres    false    233    232            �           2606    66048    answer answer_pk 
   CONSTRAINT     R   ALTER TABLE ONLY public.answer
    ADD CONSTRAINT answer_pk PRIMARY KEY (row_id);
 :   ALTER TABLE ONLY public.answer DROP CONSTRAINT answer_pk;
       public            postgres    false    216            �           2606    66050    group group_pk 
   CONSTRAINT     R   ALTER TABLE ONLY public."group"
    ADD CONSTRAINT group_pk PRIMARY KEY (row_id);
 :   ALTER TABLE ONLY public."group" DROP CONSTRAINT group_pk;
       public            postgres    false    214            �           2606    66052    question question_pk 
   CONSTRAINT     V   ALTER TABLE ONLY public.question
    ADD CONSTRAINT question_pk PRIMARY KEY (row_id);
 >   ALTER TABLE ONLY public.question DROP CONSTRAINT question_pk;
       public            postgres    false    218            �           2606    66054    role role_pk 
   CONSTRAINT     N   ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pk PRIMARY KEY (row_id);
 6   ALTER TABLE ONLY public.role DROP CONSTRAINT role_pk;
       public            postgres    false    220            �           2606    66056    schedule schedule_pk 
   CONSTRAINT     V   ALTER TABLE ONLY public.schedule
    ADD CONSTRAINT schedule_pk PRIMARY KEY (row_id);
 >   ALTER TABLE ONLY public.schedule DROP CONSTRAINT schedule_pk;
       public            postgres    false    222            �           2606    66058     student_answer student_answer_pk 
   CONSTRAINT     b   ALTER TABLE ONLY public.student_answer
    ADD CONSTRAINT student_answer_pk PRIMARY KEY (row_id);
 J   ALTER TABLE ONLY public.student_answer DROP CONSTRAINT student_answer_pk;
       public            postgres    false    224            �           2606    66060    subject subject_pk 
   CONSTRAINT     T   ALTER TABLE ONLY public.subject
    ADD CONSTRAINT subject_pk PRIMARY KEY (row_id);
 <   ALTER TABLE ONLY public.subject DROP CONSTRAINT subject_pk;
       public            postgres    false    226            �           2606    66062    test_list test_list_pk 
   CONSTRAINT     X   ALTER TABLE ONLY public.test_list
    ADD CONSTRAINT test_list_pk PRIMARY KEY (row_id);
 @   ALTER TABLE ONLY public.test_list DROP CONSTRAINT test_list_pk;
       public            postgres    false    229            �           2606    66064    test test_pk 
   CONSTRAINT     N   ALTER TABLE ONLY public.test
    ADD CONSTRAINT test_pk PRIMARY KEY (row_id);
 6   ALTER TABLE ONLY public.test DROP CONSTRAINT test_pk;
       public            postgres    false    228            �           2606    66066    user users_pk 
   CONSTRAINT     Q   ALTER TABLE ONLY public."user"
    ADD CONSTRAINT users_pk PRIMARY KEY (row_id);
 9   ALTER TABLE ONLY public."user" DROP CONSTRAINT users_pk;
       public            postgres    false    232            �           1259    66067    group_name_uindex    INDEX     L   CREATE UNIQUE INDEX group_name_uindex ON public."group" USING btree (name);
 %   DROP INDEX public.group_name_uindex;
       public            postgres    false    214            �           1259    66068    role_name_uindex    INDEX     H   CREATE UNIQUE INDEX role_name_uindex ON public.role USING btree (name);
 $   DROP INDEX public.role_name_uindex;
       public            postgres    false    220            �           1259    66069    subject_name_uindex    INDEX     N   CREATE UNIQUE INDEX subject_name_uindex ON public.subject USING btree (name);
 '   DROP INDEX public.subject_name_uindex;
       public            postgres    false    226            �           1259    66070    users_login_uindex    INDEX     M   CREATE UNIQUE INDEX users_login_uindex ON public."user" USING btree (login);
 &   DROP INDEX public.users_login_uindex;
       public            postgres    false    232            �           2606    66071     answer answer_question_row_id_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.answer
    ADD CONSTRAINT answer_question_row_id_fk FOREIGN KEY (question_id) REFERENCES public.question(row_id);
 J   ALTER TABLE ONLY public.answer DROP CONSTRAINT answer_question_row_id_fk;
       public          postgres    false    218    216    3234            �           2606    66076 !   schedule schedule_group_row_id_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.schedule
    ADD CONSTRAINT schedule_group_row_id_fk FOREIGN KEY (group_id) REFERENCES public."group"(row_id);
 K   ALTER TABLE ONLY public.schedule DROP CONSTRAINT schedule_group_row_id_fk;
       public          postgres    false    214    3230    222            �           2606    66081 %   schedule schedule_test_list_row_id_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.schedule
    ADD CONSTRAINT schedule_test_list_row_id_fk FOREIGN KEY (test_id) REFERENCES public.test_list(row_id);
 O   ALTER TABLE ONLY public.schedule DROP CONSTRAINT schedule_test_list_row_id_fk;
       public          postgres    false    222    3248    229            �           2606    66086 .   student_answer student_answer_answer_row_id_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.student_answer
    ADD CONSTRAINT student_answer_answer_row_id_fk FOREIGN KEY (answer_id) REFERENCES public.answer(row_id);
 X   ALTER TABLE ONLY public.student_answer DROP CONSTRAINT student_answer_answer_row_id_fk;
       public          postgres    false    216    224    3232            �           2606    66091 1   student_answer student_answer_test_list_row_id_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.student_answer
    ADD CONSTRAINT student_answer_test_list_row_id_fk FOREIGN KEY (test_id) REFERENCES public.test_list(row_id);
 [   ALTER TABLE ONLY public.student_answer DROP CONSTRAINT student_answer_test_list_row_id_fk;
       public          postgres    false    3248    224    229            �           2606    66096 ,   student_answer student_answer_user_row_id_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.student_answer
    ADD CONSTRAINT student_answer_user_row_id_fk FOREIGN KEY (user_id) REFERENCES public."user"(row_id);
 V   ALTER TABLE ONLY public.student_answer DROP CONSTRAINT student_answer_user_row_id_fk;
       public          postgres    false    232    3251    224            �           2606    66101 %   test_list test_list_subject_row_id_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.test_list
    ADD CONSTRAINT test_list_subject_row_id_fk FOREIGN KEY (subject_id) REFERENCES public.subject(row_id);
 O   ALTER TABLE ONLY public.test_list DROP CONSTRAINT test_list_subject_row_id_fk;
       public          postgres    false    3244    229    226            �           2606    66106 "   test_list test_list_user_row_id_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.test_list
    ADD CONSTRAINT test_list_user_row_id_fk FOREIGN KEY (teacher_id) REFERENCES public."user"(row_id);
 L   ALTER TABLE ONLY public.test_list DROP CONSTRAINT test_list_user_row_id_fk;
       public          postgres    false    229    232    3251            �           2606    66111    test test_question_row_id_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.test
    ADD CONSTRAINT test_question_row_id_fk FOREIGN KEY (question_id) REFERENCES public.question(row_id);
 F   ALTER TABLE ONLY public.test DROP CONSTRAINT test_question_row_id_fk;
       public          postgres    false    3234    228    218            �           2606    66116    test test_test_list_row_id_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.test
    ADD CONSTRAINT test_test_list_row_id_fk FOREIGN KEY (test_id) REFERENCES public.test_list(row_id);
 G   ALTER TABLE ONLY public.test DROP CONSTRAINT test_test_list_row_id_fk;
       public          postgres    false    228    3248    229            �           2606    66121    user user_group_row_id_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_group_row_id_fk FOREIGN KEY (group_id) REFERENCES public."group"(row_id);
 E   ALTER TABLE ONLY public."user" DROP CONSTRAINT user_group_row_id_fk;
       public          postgres    false    3230    232    214            �           2606    66126    user user_role_row_id_fk    FK CONSTRAINT     |   ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_role_row_id_fk FOREIGN KEY (role_id) REFERENCES public.role(row_id);
 D   ALTER TABLE ONLY public."user" DROP CONSTRAINT user_role_row_id_fk;
       public          postgres    false    3237    220    232           