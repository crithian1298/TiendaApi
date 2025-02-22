PGDMP         '                z         	   tienda_db    14.1    14.1 (               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    32803 	   tienda_db    DATABASE     d   CREATE DATABASE tienda_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Peru.1252';
    DROP DATABASE tienda_db;
                postgres    false            �            1259    32805 	   categoria    TABLE     �   CREATE TABLE public.categoria (
    id bigint NOT NULL,
    categoria character varying(255),
    descripcion character varying(255) NOT NULL,
    estado character varying(255) NOT NULL
);
    DROP TABLE public.categoria;
       public         heap    postgres    false            �            1259    32804    categoria_idcategoria_seq    SEQUENCE     �   CREATE SEQUENCE public.categoria_idcategoria_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.categoria_idcategoria_seq;
       public          postgres    false    210                       0    0    categoria_idcategoria_seq    SEQUENCE OWNED BY     N   ALTER SEQUENCE public.categoria_idcategoria_seq OWNED BY public.categoria.id;
          public          postgres    false    209            �            1259    32840 	   productos    TABLE     9  CREATE TABLE public.productos (
    idproducto bigint NOT NULL,
    descripcion character varying(255) NOT NULL,
    fechaf date NOT NULL,
    fechai date NOT NULL,
    nempresa character varying(255) NOT NULL,
    nproducto character varying(255),
    stock integer NOT NULL,
    categoria_id bigint NOT NULL
);
    DROP TABLE public.productos;
       public         heap    postgres    false            �            1259    32839    productos_idproducto_seq    SEQUENCE     �   CREATE SEQUENCE public.productos_idproducto_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.productos_idproducto_seq;
       public          postgres    false    212                       0    0    productos_idproducto_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.productos_idproducto_seq OWNED BY public.productos.idproducto;
          public          postgres    false    211            �            1259    32854    roles    TABLE     X   CREATE TABLE public.roles (
    id bigint NOT NULL,
    nombre character varying(60)
);
    DROP TABLE public.roles;
       public         heap    postgres    false            �            1259    32853    roles_id_seq    SEQUENCE     u   CREATE SEQUENCE public.roles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.roles_id_seq;
       public          postgres    false    214                        0    0    roles_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.roles_id_seq OWNED BY public.roles.id;
          public          postgres    false    213            �            1259    32861    usuario    TABLE     �   CREATE TABLE public.usuario (
    id bigint NOT NULL,
    email character varying(255),
    nombre character varying(255),
    password character varying(255),
    username character varying(255)
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            �            1259    32860    usuario_id_seq    SEQUENCE     w   CREATE SEQUENCE public.usuario_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.usuario_id_seq;
       public          postgres    false    216            !           0    0    usuario_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.usuario_id_seq OWNED BY public.usuario.id;
          public          postgres    false    215            �            1259    32869    usuario_roles    TABLE     b   CREATE TABLE public.usuario_roles (
    usuario_id bigint NOT NULL,
    rol_id bigint NOT NULL
);
 !   DROP TABLE public.usuario_roles;
       public         heap    postgres    false            o           2604    32808    categoria id    DEFAULT     u   ALTER TABLE ONLY public.categoria ALTER COLUMN id SET DEFAULT nextval('public.categoria_idcategoria_seq'::regclass);
 ;   ALTER TABLE public.categoria ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    210    209    210            p           2604    32843    productos idproducto    DEFAULT     |   ALTER TABLE ONLY public.productos ALTER COLUMN idproducto SET DEFAULT nextval('public.productos_idproducto_seq'::regclass);
 C   ALTER TABLE public.productos ALTER COLUMN idproducto DROP DEFAULT;
       public          postgres    false    211    212    212            q           2604    32857    roles id    DEFAULT     d   ALTER TABLE ONLY public.roles ALTER COLUMN id SET DEFAULT nextval('public.roles_id_seq'::regclass);
 7   ALTER TABLE public.roles ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    214    213    214            r           2604    32864 
   usuario id    DEFAULT     h   ALTER TABLE ONLY public.usuario ALTER COLUMN id SET DEFAULT nextval('public.usuario_id_seq'::regclass);
 9   ALTER TABLE public.usuario ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    215    216                      0    32805 	   categoria 
   TABLE DATA           G   COPY public.categoria (id, categoria, descripcion, estado) FROM stdin;
    public          postgres    false    210   �,                 0    32840 	   productos 
   TABLE DATA           v   COPY public.productos (idproducto, descripcion, fechaf, fechai, nempresa, nproducto, stock, categoria_id) FROM stdin;
    public          postgres    false    212   /-                 0    32854    roles 
   TABLE DATA           +   COPY public.roles (id, nombre) FROM stdin;
    public          postgres    false    214   �-                 0    32861    usuario 
   TABLE DATA           H   COPY public.usuario (id, email, nombre, password, username) FROM stdin;
    public          postgres    false    216   .                 0    32869    usuario_roles 
   TABLE DATA           ;   COPY public.usuario_roles (usuario_id, rol_id) FROM stdin;
    public          postgres    false    217   /       "           0    0    categoria_idcategoria_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.categoria_idcategoria_seq', 4, true);
          public          postgres    false    209            #           0    0    productos_idproducto_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.productos_idproducto_seq', 11, true);
          public          postgres    false    211            $           0    0    roles_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.roles_id_seq', 1, false);
          public          postgres    false    213            %           0    0    usuario_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.usuario_id_seq', 4, true);
          public          postgres    false    215            t           2606    32810    categoria categoria_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.categoria
    ADD CONSTRAINT categoria_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.categoria DROP CONSTRAINT categoria_pkey;
       public            postgres    false    210            v           2606    32847    productos productos_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.productos
    ADD CONSTRAINT productos_pkey PRIMARY KEY (idproducto);
 B   ALTER TABLE ONLY public.productos DROP CONSTRAINT productos_pkey;
       public            postgres    false    212            x           2606    32859    roles roles_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_pkey;
       public            postgres    false    214            z           2606    32877 #   usuario uk5171l57faosmj8myawaucatdw 
   CONSTRAINT     _   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT uk5171l57faosmj8myawaucatdw UNIQUE (email);
 M   ALTER TABLE ONLY public.usuario DROP CONSTRAINT uk5171l57faosmj8myawaucatdw;
       public            postgres    false    216            |           2606    32875 #   usuario uk863n1y3x0jalatoir4325ehal 
   CONSTRAINT     b   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT uk863n1y3x0jalatoir4325ehal UNIQUE (username);
 M   ALTER TABLE ONLY public.usuario DROP CONSTRAINT uk863n1y3x0jalatoir4325ehal;
       public            postgres    false    216            ~           2606    32868    usuario usuario_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    216            �           2606    32873     usuario_roles usuario_roles_pkey 
   CONSTRAINT     n   ALTER TABLE ONLY public.usuario_roles
    ADD CONSTRAINT usuario_roles_pkey PRIMARY KEY (usuario_id, rol_id);
 J   ALTER TABLE ONLY public.usuario_roles DROP CONSTRAINT usuario_roles_pkey;
       public            postgres    false    217    217            �           2606    32878 )   usuario_roles fkbt9i9yrb9ug88xnh82n9m60pr    FK CONSTRAINT     �   ALTER TABLE ONLY public.usuario_roles
    ADD CONSTRAINT fkbt9i9yrb9ug88xnh82n9m60pr FOREIGN KEY (rol_id) REFERENCES public.roles(id);
 S   ALTER TABLE ONLY public.usuario_roles DROP CONSTRAINT fkbt9i9yrb9ug88xnh82n9m60pr;
       public          postgres    false    214    217    3192            �           2606    32848 %   productos fkpg3xiei77fmdbpx20n8i9txs6    FK CONSTRAINT     �   ALTER TABLE ONLY public.productos
    ADD CONSTRAINT fkpg3xiei77fmdbpx20n8i9txs6 FOREIGN KEY (categoria_id) REFERENCES public.categoria(id);
 O   ALTER TABLE ONLY public.productos DROP CONSTRAINT fkpg3xiei77fmdbpx20n8i9txs6;
       public          postgres    false    212    3188    210            �           2606    32883 )   usuario_roles fkqblnumndby0ftm4c7sg6uso6p    FK CONSTRAINT     �   ALTER TABLE ONLY public.usuario_roles
    ADD CONSTRAINT fkqblnumndby0ftm4c7sg6uso6p FOREIGN KEY (usuario_id) REFERENCES public.usuario(id);
 S   ALTER TABLE ONLY public.usuario_roles DROP CONSTRAINT fkqblnumndby0ftm4c7sg6uso6p;
       public          postgres    false    217    3198    216               m   x�3��IM�H����y�%�EE����%�e�\F�N�I�)�Ŝ��yť��
)�
I!�Լ���Ԝ�D���s�g�?�1gYjQJi��T�	gZQi	��TE� h{4         �   x���M
�@�יS�#ɠ�]����ԉ��60��ߌ�/H���:��U�NS��%If�[o
hm �� �Q��p�~M��\�\��3[�)�/��o�`&/����8�8��;DO�%���B���Thj=6��ub�'����=s�8��[�         !   x�3���q�v�2��]|=��b���� t��         �   x����n�@ ����s����˂�(��L5�4i(� #�^|��V#�n��wr0H�r���Oy��%�y4 .aEj_�<��8��9�؆h�[6z��e��X���ei#�*�(��@x�������7� �}-���k��q����4_ �ajk�g+Z�̎;,_��H��u�K8š�n�@5��k3������_���>��)ek�O~��D;�rMA����r7�c�ϫ��*�W!�V+|�            x�3�4�2�4�2b ����� ��     