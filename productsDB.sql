PGDMP     &    (                 {         
   productsDB    15.1    15.1 %               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    18858 
   productsDB    DATABASE     �   CREATE DATABASE "productsDB" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
    DROP DATABASE "productsDB";
                postgres    false            �            1259    18972 	   check_out    TABLE     L  CREATE TABLE public.check_out (
    check_out_id integer NOT NULL,
    product_id integer NOT NULL,
    user_id integer,
    product_name character varying(255) NOT NULL,
    price double precision NOT NULL,
    product_quantity integer NOT NULL,
    product_total double precision NOT NULL,
    user_name character varying(255)
);
    DROP TABLE public.check_out;
       public         heap    postgres    false            �            1259    18971    check_out_check_out_id_seq    SEQUENCE     �   CREATE SEQUENCE public.check_out_check_out_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.check_out_check_out_id_seq;
       public          postgres    false    224                       0    0    check_out_check_out_id_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.check_out_check_out_id_seq OWNED BY public.check_out.check_out_id;
          public          postgres    false    223            �            1259    18978    check_out_seq    SEQUENCE     w   CREATE SEQUENCE public.check_out_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.check_out_seq;
       public          postgres    false            �            1259    18939    product_table    TABLE       CREATE TABLE public.product_table (
    product_id integer NOT NULL,
    product_name character varying(255) NOT NULL,
    price double precision NOT NULL,
    quantity integer NOT NULL,
    image_url character varying(10485760) NOT NULL,
    user_name character varying(255)
);
 !   DROP TABLE public.product_table;
       public         heap    postgres    false            �            1259    18938    product_table_product_id_seq    SEQUENCE     �   CREATE SEQUENCE public.product_table_product_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.product_table_product_id_seq;
       public          postgres    false    222                       0    0    product_table_product_id_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.product_table_product_id_seq OWNED BY public.product_table.product_id;
          public          postgres    false    221            �            1259    18879    product_table_seq    SEQUENCE     {   CREATE SEQUENCE public.product_table_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.product_table_seq;
       public          postgres    false            �            1259    18870    producttable_prouductid_seq    SEQUENCE     �   CREATE SEQUENCE public.producttable_prouductid_seq
    AS integer
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.producttable_prouductid_seq;
       public          postgres    false            �            1259    18930 
   user_table    TABLE     �   CREATE TABLE public.user_table (
    user_id integer NOT NULL,
    user_name character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    role character varying(255) NOT NULL
);
    DROP TABLE public.user_table;
       public         heap    postgres    false            �            1259    18868    user_table_id_seq    SEQUENCE     {   CREATE SEQUENCE public.user_table_id_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.user_table_id_seq;
       public          postgres    false            �            1259    18929    user_table_product_id_seq    SEQUENCE     �   CREATE SEQUENCE public.user_table_product_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.user_table_product_id_seq;
       public          postgres    false    220                        0    0    user_table_product_id_seq    SEQUENCE OWNED BY     T   ALTER SEQUENCE public.user_table_product_id_seq OWNED BY public.user_table.user_id;
          public          postgres    false    219            �            1259    18884    user_table_seq    SEQUENCE     x   CREATE SEQUENCE public.user_table_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.user_table_seq;
       public          postgres    false            �            1259    18859    usertable_id_seq    SEQUENCE     �   CREATE SEQUENCE public.usertable_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.usertable_id_seq;
       public          postgres    false            w           2604    18975    check_out check_out_id    DEFAULT     �   ALTER TABLE ONLY public.check_out ALTER COLUMN check_out_id SET DEFAULT nextval('public.check_out_check_out_id_seq'::regclass);
 E   ALTER TABLE public.check_out ALTER COLUMN check_out_id DROP DEFAULT;
       public          postgres    false    223    224    224            v           2604    18942    product_table product_id    DEFAULT     �   ALTER TABLE ONLY public.product_table ALTER COLUMN product_id SET DEFAULT nextval('public.product_table_product_id_seq'::regclass);
 G   ALTER TABLE public.product_table ALTER COLUMN product_id DROP DEFAULT;
       public          postgres    false    221    222    222            u           2604    18933    user_table user_id    DEFAULT     {   ALTER TABLE ONLY public.user_table ALTER COLUMN user_id SET DEFAULT nextval('public.user_table_product_id_seq'::regclass);
 A   ALTER TABLE public.user_table ALTER COLUMN user_id DROP DEFAULT;
       public          postgres    false    220    219    220                      0    18972 	   check_out 
   TABLE DATA           �   COPY public.check_out (check_out_id, product_id, user_id, product_name, price, product_quantity, product_total, user_name) FROM stdin;
    public          postgres    false    224   �)                 0    18939    product_table 
   TABLE DATA           h   COPY public.product_table (product_id, product_name, price, quantity, image_url, user_name) FROM stdin;
    public          postgres    false    222   }*                 0    18930 
   user_table 
   TABLE DATA           H   COPY public.user_table (user_id, user_name, password, role) FROM stdin;
    public          postgres    false    220   �=       !           0    0    check_out_check_out_id_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.check_out_check_out_id_seq', 1, false);
          public          postgres    false    223            "           0    0    check_out_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.check_out_seq', 4401, true);
          public          postgres    false    225            #           0    0    product_table_product_id_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.product_table_product_id_seq', 1, true);
          public          postgres    false    221            $           0    0    product_table_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.product_table_seq', 1403, true);
          public          postgres    false    217            %           0    0    producttable_prouductid_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.producttable_prouductid_seq', 1, false);
          public          postgres    false    216            &           0    0    user_table_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.user_table_id_seq', 1, false);
          public          postgres    false    215            '           0    0    user_table_product_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.user_table_product_id_seq', 1, false);
          public          postgres    false    219            (           0    0    user_table_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.user_table_seq', 1051, true);
          public          postgres    false    218            )           0    0    usertable_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.usertable_id_seq', 1, false);
          public          postgres    false    214            }           2606    18977    check_out check_out_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.check_out
    ADD CONSTRAINT check_out_pkey PRIMARY KEY (check_out_id);
 B   ALTER TABLE ONLY public.check_out DROP CONSTRAINT check_out_pkey;
       public            postgres    false    224            {           2606    18946     product_table product_table_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.product_table
    ADD CONSTRAINT product_table_pkey PRIMARY KEY (product_id);
 J   ALTER TABLE ONLY public.product_table DROP CONSTRAINT product_table_pkey;
       public            postgres    false    222            y           2606    18937    user_table user_table_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.user_table
    ADD CONSTRAINT user_table_pkey PRIMARY KEY (user_id);
 D   ALTER TABLE ONLY public.user_table DROP CONSTRAINT user_table_pkey;
       public            postgres    false    220               �   x�}��n�0Dg�+�ER�4w��E�Z(bN
$_Q�C�rXG`	\�𑮷��|`�&�ѱ����k#P�����C�p���4n����,�X<+p^^ާe�},)�SZק!���t���@�0EN[�M�H'ɪ�D��X�Vm��1�"�/cׄ�c����>?9�hѢ�d��<��J���^́D�S����m �b��-�a��vy5���s�            x��yǮ�H����W4j��}Ԫ�ɠA-$��Z����{Y�Uh�b0���~��͏�E�(�}���ϿP��"H�+���oU�9X�y��x�	�?A�1�����%�2s��'� �����Sv��g�o�l�k���E�S�";���]v���4�Va�pR��C_��\�ja�rP�,�.�%�Ъ^Ь9�������������1�g��|� ��e�ҙ��Y�d8���%�'ä�fs���.�)��x"{��<���c��c9�b���s�%�kYέ������,_⛽gI%[�.TgؤCp�kitOX7�L�*@�a���������)c�����������,��@z`��q�fN�1v���<��=E��G���D���z�T��ZU�*_���'T��٢g����X��Ǎ֣-���:ܴ���Ψ�z�j-s���w��2t�g��Wy����81�e��jWqۇ�%�ڊ9`-	��l]�?�3��P^���i�f���!��i�u�v�#c@��R"�;*���F��W`�
FC����-��3���#���w�}����{!������ƹ��
�����ؠ��̦�(in�@[�_Eۿ:�AL)����Ę�}�,�^�j+���Uɘ���%�՚6/D۶�N���ȬO�4����!�ϩ��B�A65�|��J�v�4��u�+U4p;"�8�3�$�@�n�޹]���Q��b�KFV�T��E��Ϊ� �O��Rs�vg*q]c���
��w�Gu�*���8��<Kh�V`�NILx�r�a�t��U��	� ͨ�/��q�?y���+ihܸ�DA�]mC����M{��m�v{����g֌m��U�"�+��J-�I�/v�W=
n�k:z!_���Yn�9�4B&���(ף�憭�G��2S&l�-������'�ϸ���`�Z�goi՝s	i����c�8�n��j�Y/�������=Ɲ<щ��N�������U��'�؈R�V�E�^��]�MYXEpX#ivuQ���J��5b�a�J��,��9�����H��u�QD$X����L^��XB���P{te�^P��%�	{ZԀ�ZQm�VlVaU������I������L����Y��Bz}�ꕰݳ�4N�@҅���.u���n�NE��F>,��" Z�R��>�l'k��Q�<43U����롧�J ����Ӌ �bҒ�Bus�5/{փc�ǎ�1��LJXz��Q� �?����
��k��-"��NP��5�1������t*��C0��^�nYK�(M�l��ƞ+��<�g硒�,��2�J��(<#5֓:���H�X��c�}��q{��r���',�v�M(��f��}Wҁ$��4��u�z�e��r�;�N2�GĽ����H(2�w��C� Td�G֊�(��ޓ$M!�
s��2)��o$�x�u�;pMu��t��;(�3�` ��]n�)Qc��Ss�y�0���f��_%���6���^:K6���ܩ���\�v�k�c�>�aUAI`�x�4�E�F}��37�ς�KAx�T�ב#���T�޹Y���ΐ�紦S���e���	������������
��k������t���\�p�����?�^�y��p-z=s�T�X���/s�.d�8{�«��T0���b%Zx�|o
�6@��~��$2�Q�$n[�i��^����\<�r�Z��֡5����q�B�7�3�|�
�y�A{~`@�gU�O�t����ҡ��ЛRҶ�*��� $|�4Ź�*�^��}��'�$�CuW�_U�l^�W��r\/��7�|!Ұ�@�`-���5���}�I4�9 ��5�hch�p�]'
�vD�3Z�D�'�{7�L�;pBl0u�0p��V�]Բ��̜��vlV�9�vd������}���9�v��vV)��",01��e_FPC��,Z���K��j
ܶ��8=����<I|�x
w^�Ixř��`���p:暃���vv����gʊ�Bo�V�#���m��Y7A�7�vG�d�U��69qk���ӏ��3�
ꎤ�U�h��.��M��y?�Q3�={�53���_[������#����_��<P� ��S;�x�F����ۢأˬ^N-\yAa�;��J�͝�`8�����fF���Fh���0�:=��K/py��2���k&�0�?�e>�ܩI��a2���)O2cS 7�;���Ϝ���_pX�|QY	����Zi-6-i��r$�U-W��{[q����$�5'(�O��{N�c �������d���eۗ���s�_�ڽy��Q��jyUJ�8s�*nrg�H�|,$�	�<�� O��G��Q��Q��!H5���Ն�UWʪ*�Fv�	2��sj�D� 2�aܚ�<�p�o@|�7�:Վ2�d�Ks��~��k+�H��H6`�<c�M����j|mDy�R/8#�{C�C��ԗ�mV-����5�>�7���a$�V��������ɻ�M�qa��FS�5��o�-���mpՂ��P�ڮ̤@"����i	��s�0�ɴn�쮪T�0J4I௯po}�לء��^�E�S]U^X�
��Z VJW�.t�w�!�2����������v�R^�K��+O=��x� ����q�'�0vQ��8�D?ZV�����m?��h���X�ʱ�/6��+彥M>:�,&���M��x�*p�I<5U�`��8&ۮW�0M/?�eӾ$\a	0���|FD�$I ,B�]�!
��2�B�+
Q�y�愢z��x��7թV��~�
��i��(!���,6���� )fyb������RgA�Fr��ی˂@:.�#���7�_�f�i.
�D�Ī�'5[j�'�_9�}$D�m�
X/��z��
��al�!���*b\�
���- x�|�6��S@�ߦzs��4�v��)�����ߧf�@_Uȗ�����ԑ/��Z�=�'�X�Iy j�@��Q�@���ڣp�{�� � ��0o��+�{����^��]�������3��sew	)���`��!��aZ�h�x0L��5�l[e^����!"�:�7&�ˣ���l|�n��$D5�"wA[�֤oSL�;G\��J��tV��5ˋ���sɨ������x=�Tx����!	V��jJ&W��ٻ�ӊ�~�o6^��
HD6&A��u}<\��O��$E�#'n d����-1[���0�c�w�����L�B�N��ႌ�c>�f�!Hޝ���L]��m6�8�C�?g���!�j�]q�[3i{����_��A�n�&��j�[�O�#�cX�g���袚��\IÒ,��O�nW�:ᮺ�SF��'<��F_�;�m����!�Ǫh�6""]�}����� �r����w�=g{��>o#��C���L�/wv{.��ޞ���HZ&-Y?G39�H �"���J�{Q0��0�^�`qMN{U�0α�����Dٰ��ǰꔣUMи%)��f8T%��l�Q����)G��o?p��w��]�����%qJ
�v8[�,�T�.p�^�0�@9��t��F��xaNT�x��;�MG� Gϸ��+k=��k�>ϵ�k_��Ғ/��*[,S��g�w�J��Q���c9�� �uggO�����AZ��ܶ�Z�KL�o��M��k�fE�q�z�S�:~�6�y���p��c�m�b�z���UPk��g�
��"��(�1S�)N�f�>�޹��>z���B��a3g��}Z��Om1�I��L	�P8�E�3Y���}��� <9-=�_�r���,wpJ�`��cw^���La�%Y�8���Ni�S���n�L��$&���'�˅��#Òv���q2r�x�;+y5�F�T{{�2�ՠ�i�����������.d�N�'Wt�ٻ��,\+���l�lo�������@�hO ��	^6��@��Є��j-7vAʵdS�*���yK7���Z�|`�
�	�Zq������x<���@�K΅|��X?�޼Vщ��re�e��:S]�T�v���R;�� W  ��WMկ���59�c8L��`z�U)5a�C���>�0+�^mD�j�kx�:�X�=���������\�47:�����̀D�����u���ޏk:�$�M��-�x�5�<�fu�Fs�}�琚WN	�r����������uAΠU@[2D��CU#ǞV�֤�j���f�o�"��%[
��K�p�XY��l����8�ۺ4Re��B�2:*[o?����g��-�Q�a�Յ���,��K�Jp�"�aO�=��ח���/����E�_8�������4�,�a���G:t�U�/ B��D� �@8�C���
c�������-3ڷ�?��:�~�c���w�)
�0���������~������ a��hD�����sg����@�z�A8�����ė�U_�_|��	���y��׸�����ЏrY�J���g��������#��ԂMч���-������5H���y�%��y��m�4��1ޟ��uV��U_�m���j����G5�U��󰍿@���,��@	����i��a��2�J2��c#0��i�~Y����2��������s�0�֡=o�f�[xv��u�����ܒ����G:�]nR��b��}�{��.��M�_ҡ��1˶܂�_
�S���7�ȓ�+��=�Xe\� MgPL�7���7���7��7��T��I<`
�{��f������-�m���e�e�k���������Ǳ��R$N������TX�Z�;���������7!D�!���$�����q���W�c$�[ѭ����.�6���4�ۏ�~I�4N�t������?���2(��         �   x�M�1� ����4VK�����4���DZ(Fp������������Ϊ�q^B�u��ʘdU`�A�a�.��>�.�l�	ΩW�}���`�(�)H)��+�1Ձ� �Im��#�Fr�ܸ��n!;�iZIs�A����1�A�jVRZ�\ ,g�I��c$f�     